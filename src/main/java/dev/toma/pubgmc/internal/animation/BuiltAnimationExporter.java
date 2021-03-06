package dev.toma.pubgmc.internal.animation;

import com.google.gson.JsonParseException;
import com.mojang.blaze3d.platform.GlStateManager;
import dev.toma.pubgmc.client.animation.gun.SimpleGunAnimation;
import dev.toma.pubgmc.internal.InternalData;
import dev.toma.pubgmc.util.object.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class BuiltAnimationExporter {

    public static void exportAnimation() {
        LocalDateTime time = LocalDateTime.now();
        String fileName = "animation_" + normal(time.getDayOfMonth()) + normal(time.getMonthValue()) + time.getYear() + "_" + normal(time.getHour()) + normal(time.getMinute());
        File file = findSuitableNameFor(fileName);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(export());
            writer.close();
            StringTextComponent textComponent = new StringTextComponent("File has been created, path: " + file.getCanonicalPath());
            textComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, file.getParentFile().getCanonicalPath()));
            Minecraft.getInstance().player.sendMessage(textComponent);
        } catch (IOException e) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.RED + "Could not create file: " + e.toString()));
            e.printStackTrace();
        } catch (JsonParseException e) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.RED + "Error serializing animation: " + e.toString()));
            e.printStackTrace();
        } catch (Exception e) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.RED + "Unknown error: " + e.toString()));
            e.printStackTrace();
        }
    }

    private static String export() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("###.##", symbols);
        StringBuilder builder = new StringBuilder();
        float first = 0.0F;
        for (BuilderAnimationStep step : InternalData.steps) {
            float last = first + step.length;
            builder.append("addStep(").append(df.format(first)).append("F, ").append(df.format(last)).append("F, ").append(InternalData.buildingGunAnimation ? "SimpleGunAnimation.create()" : "SimpleAnimation.newSimpleAnimation()");
            first = last;
            List<IAnimationPart> specialParts = new ArrayList<>();
            for (IAnimationPart part : IAnimationPart.PARTS) {
                AnimationData data = step.map.get(part);
                if (data.isEmpty()) continue;
                if(part.isSpecial()) {
                    specialParts.add(part);
                } else {
                    builder.append(".").append(part.getFunctionName()).append(part.parameters()).append("-> {").append(generateAnimation(data, df)).append("})");
                }
            }
            if(!specialParts.isEmpty()) {
                if(specialParts.size() == 1) {
                    IAnimationPart part = specialParts.get(0);
                    AnimationData data = step.map.get(part);
                    builder.append(".").append(part.getFunctionName()).append(part.parameters()).append("-> {").append(generateAnimation(data, df)).append("})");
                } else {
                    builder.append(".model((i, f) -> {");
                    builder.append("\nswitch(i) {\n");
                    for (IAnimationPart part : specialParts) {
                        AnimationData data = step.map.get(part);
                        builder.append("case ").append(part.getDisplayName()).append(":").append(generateAnimation(data, df)).append("break;");
                    }
                    builder.append("}})");
                }
            }
            builder.append(".create());\n");
        }
        if (first > 1.0F) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "Animation step range is over 100%! Your animation will be cut out. Got " + df.format(first)));
        } else if (first < 1.0F) {
            Minecraft.getInstance().player.sendMessage(new StringTextComponent(TextFormatting.YELLOW + "Animation step range is not equal 100%! This will mess up your animation. Got " + df.format(first)));
        }
        return builder.toString();
    }

    private static String generateAnimation(AnimationData data, DecimalFormat df) {
        StringBuilder builder = new StringBuilder();
        IContext.Translation tctx = data.translation;
        if (!tctx.isEmpty()) {
            builder.append("GlStateManager.translatef(");
            handleTranslationValue(builder, df, tctx.baseX, tctx.newX, true);
            handleTranslationValue(builder, df, tctx.baseY, tctx.newY, true);
            handleTranslationValue(builder, df, tctx.baseZ, tctx.newZ, false);
            builder.append(");");
        }
        IContext.Rotation ctx = data.rotation;
        if (!ctx.isEmpty()) {
            List<Map.Entry<InternalData.Axis, Pair<Float, Float>>> list = new ArrayList<>(ctx.rotations.entrySet());
            list.sort(Comparator.comparingInt(o -> o.getKey().index()));
            for (Map.Entry<InternalData.Axis, Pair<Float, Float>> entry : list) {
                builder.append("GlStateManager.rotatef(");
                Pair<Float, Float> sdP = entry.getValue();
                handleTranslationValue(builder, df, sdP.getLeft(), sdP.getRight(), true);
                switch (entry.getKey()) {
                    case X:
                        builder.append("1.0F, 0.0F, 0.0F);");
                        break;
                    case Y:
                        builder.append("0.0F, 1.0F, 0.0F);");
                        break;
                    case Z:
                        builder.append("0.0F, 0.0F, 1.0F);");
                        break;
                }
            }
        }
        return builder.toString();
    }

    private static void handleTranslationValue(StringBuilder builder, DecimalFormat format, float s, float d, boolean addComma) {
        boolean flag = false;
        if (s != 0) {
            builder.append(format.format(s)).append("F");
            flag = true;
        }
        if (d != 0) {
            flag = true;
            if (d < 0) builder.append(format.format(d)).append("F");
            else builder.append("+").append(format.format(d)).append("F");
            builder.append("*f");
        }
        if (!flag) builder.append("0.0F");
        if (addComma) builder.append(", ");
    }

    private static String getFunctionName(IAnimationPart part) {
        return part.getFunctionName();
    }

    private static String normal(int input) {
        if (input < 10) {
            return "0" + input;
        } else return input + "";
    }

    private static File findSuitableNameFor(String name) {
        File export = new File(Minecraft.getInstance().gameDir, "export");
        if (!export.exists()) {
            export.mkdirs();
        }
        File file = new File(export, name + ".txt");
        if (!file.exists()) {
            return file;
        } else {
            int added = 0;
            while (true) {
                String newName = name + "_" + added;
                File ff = new File(export, newName + ".txt");
                if (!ff.exists()) {
                    return ff;
                }
                added++;
            }
        }
    }
}
