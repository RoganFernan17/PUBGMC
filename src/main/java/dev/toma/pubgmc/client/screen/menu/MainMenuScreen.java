package dev.toma.pubgmc.client.screen.menu;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.client.screen.ComponentScreen;
import dev.toma.pubgmc.client.screen.component.*;
import dev.toma.pubgmc.content.ContentManager;
import dev.toma.pubgmc.content.ContentResult;
import dev.toma.pubgmc.content.MenuDisplayContent;
import dev.toma.pubgmc.util.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.RenderComponentsUtil;
import net.minecraft.client.gui.screen.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.client.gui.GuiModList;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainMenuScreen extends ComponentScreen implements RefreshListener {

    static final ResourceLocation DISCORD_ICON = Pubgmc.makeResource("textures/icons/discord.png");
    static final ResourceLocation CF_ICON = Pubgmc.makeResource("textures/icons/curseforge.png");
    static final ResourceLocation PAYPAL_ICON = Pubgmc.makeResource("textures/icons/paypal.png");
    static final ResourceLocation TITLE = Pubgmc.makeResource("textures/screen/title.png");
    static final ResourceLocation BACKGROUND_TEXTURE = Pubgmc.makeResource("textures/screen/main_menu.png");

    public MainMenuScreen() {
        super(new TranslationTextComponent("narrator.screen.title"));
    }

    @Override
    public void onRefresh() {
        init(minecraft, width, height);
    }

    @Override
    public void initComponents() {
        int wd4 = width / 4;
        int w = 2 * wd4 - 30;
        boolean splitModsAndQuitButtons = height < 280;
        int initialHeight = !splitModsAndQuitButtons ? 80 : 0;
        // anouncements
        addComponent(new EventPanelComponent(15, initialHeight + 20, w, 68));
        // singleplayer
        int hw = w / 2;
        // TODO
        ButtonComponent community = new ButtonComponent(15, initialHeight + 100, hw, 20, "Community maps", c -> minecraft.displayGuiScreen(new WorkInProgressScreen(this)));
        ButtonComponent myWorlds = new ButtonComponent(15 + hw, initialHeight + 100, hw, 20, "My Worlds", c -> minecraft.displayGuiScreen(new WorldSelectionScreen(this)));
        addComponent(new HoverSplitButton(15, initialHeight + 100, w, 20, "Singleplayer", community, myWorlds));
        // multiplayer
        // TODO
        ButtonComponent official = new ButtonComponent(15, initialHeight + 125, hw, 20, "Official servers", c -> minecraft.displayGuiScreen(new WorkInProgressScreen(this)));
        ButtonComponent myServers = new ButtonComponent(15 + hw, initialHeight + 125, hw, 20, "Server list", c -> minecraft.displayGuiScreen(new MultiplayerScreen(this)));
        addComponent(new HoverSplitButton(15, initialHeight + 125, w, 20, "Multiplayer", official, myServers));
        // settings
        addComponent(new ButtonComponent(15, initialHeight + 150, w, 20, "Settings", c -> minecraft.displayGuiScreen(new OptionsScreen(this, minecraft.gameSettings))));
        int lowestPoint;
        // mods & quit buttons
        if(splitModsAndQuitButtons) {
            int half = w / 2;
            addComponent(new ButtonComponent(15, 175, half - 5, 20, "Mods", c -> minecraft.displayGuiScreen(new GuiModList(this))));
            addComponent(new ButtonComponent(15 + half + 5, 175, half - 5, 20, "Quit", c -> minecraft.shutdown()));
            lowestPoint = 195;
        } else {
            addComponent(new ButtonComponent(15, initialHeight + 175, w, 20, "Mods", c -> minecraft.displayGuiScreen(new GuiModList(this))));
            addComponent(new ButtonComponent(15, initialHeight + 200, w, 20, "Quit", c -> minecraft.shutdown()));
            lowestPoint = 220;
        }
        // news panel
        addComponent(new InfoPanelComponent(15 + 2 * wd4, 20, 2 * wd4 - 30, lowestPoint - 20 + initialHeight, this));
        // title
        if(!splitModsAndQuitButtons) addComponent(new Component(40, 25, w - 50, 50) {
            @Override
            public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
                mc.getTextureManager().bindTexture(TITLE);
                RenderHelper.drawTexturedShape(x, y, x + width, y + height);
            }
        });
        // discord server ad
        addComponent(new LinkImageComponent(0, height - 20, 20, 20, DISCORD_ICON, "https://discord.gg/WmdUKZz", this).withInfo("Official discord server"));
        // official mod host site
        addComponent(new LinkImageComponent(20, height - 20, 20, 20, CF_ICON, "https://www.curseforge.com/minecraft/mc-mods/pubgmc-mod", this).withInfo("Mod info website").notificationOn(Pubgmc.isOutdated()));
        // paypal donation
        addComponent(new LinkImageComponent(40, height - 20, 20, 20, PAYPAL_ICON, "https://www.paypal.com/cgi-bin/webscr?return=https://www.curseforge.com/projects/297074&cn=Add+special+instructions+to+the+addon+author()&business=novotny.tom96%40gmail.com&bn=PP-DonationsBF:btn_donateCC_LG.gif:NonHosted&cancel_return=https://www.curseforge.com/projects/297074&lc=US&item_name=Support+PUBGMC+project+development&cmd=_donations&rm=1&no_shipping=1&currency_code=USD", this).withInfo("Donations"));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        FontRenderer renderer = minecraft.fontRenderer;
        minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        RenderHelper.drawTexturedShape(0, 0, width, height);
        super.render(mouseX, mouseY, partialTicks);
        renderer.drawString("Copyright Mojang AB. Do not distribute!", width - 200, height - 10, 0xffffff);
    }

    static class HoverSplitButton extends ButtonComponent {

        private final ButtonComponent b1, b2;

        public HoverSplitButton(int x, int y, int w, int h, String text, ButtonComponent b1, ButtonComponent b2) {
            super(x, y, w, h, text, null);
            this.b1 = b1;
            this.b2 = b2;
        }

        @Override
        public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            boolean hovered = isMouseOver(mouseX, mouseY);
            if(hovered) {
                b1.draw(mc, mouseX, mouseY, partialTicks);
                b2.draw(mc, mouseX, mouseY, partialTicks);
            } else {
                RenderHelper.drawColoredShape(x, y, x + width, y + height, 0.0F, 0.0F, 0.0F, 0.5F);
                if(hovered && isEnabled()) {
                    RenderHelper.drawColoredShape(x, y, x + width, y + height, 1.0F, 1.0F, 1.0F, 0.5F);
                }
                int w = mc.fontRenderer.getStringWidth(displayString);
                mc.fontRenderer.drawStringWithShadow(displayString, x + (width - w) / 2.0f, y + (height - mc.fontRenderer.FONT_HEIGHT) / 2.0f, hovered ? 0xffff00 : 0xffffff);
            }
        }

        @Override
        public void handleClicked(double mouseX, double mouseY, int mouseButton) {
            if(b1.isMouseOver(mouseX, mouseY)) {
                b1.handleClicked(mouseX, mouseY, mouseButton);
            } else b2.handleClicked(mouseX, mouseY, mouseButton);
        }
    }

    static class InfoPanelComponent extends Component {

        private final List<ITextComponent> textComponents = new ArrayList<>();
        private final Screen parent;

        public InfoPanelComponent(int x, int y, int width, int height, Screen screen) {
            super(x, y, width, height);
            ContentResult result = Pubgmc.getContentManager().getCachedResult();
            String[] strings = new String[0];
            if(result != null) {
                strings = result.getNews();
            }
            int max = width - 20;
            FontRenderer renderer = Minecraft.getInstance().fontRenderer;
            for(String string : strings) {
                ITextComponent component = ForgeHooks.newChatWithLinks(string, false);
                if(max >= 0) {
                    textComponents.addAll(RenderComponentsUtil.splitText(component, max, renderer, true, true));
                }
            }
            if(textComponents.isEmpty()) {
                StringTextComponent stc = new StringTextComponent(TextFormatting.RED + "Unable to receive latest news, check your internet connection");
                textComponents.addAll(RenderComponentsUtil.splitText(stc, max, renderer, true, true));
            }
            int lineLimit = height / (renderer.FONT_HEIGHT + 1) - 1;
            boolean flag = false;
            if(textComponents.size() > lineLimit) {
                lineLimit -= 1;
                flag = true;
            }
            while (textComponents.size() > lineLimit) {
                textComponents.remove(textComponents.size() - 1);
            }
            if(flag) textComponents.add(new StringTextComponent(TextFormatting.YELLOW.toString() + TextFormatting.ITALIC + "Click to read more..."));
            this.parent = screen;
        }

        @Override
        public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            RenderHelper.drawColoredShape(x, y, x + width, y + height, 0.0F, 0.0F, 0.0F, isMouseOver(mouseX, mouseY) ? 0.7F : 0.5F);
            for(int i = 0; i < textComponents.size(); i++) {
                if(i >= textComponents.size()) break;
                ITextComponent component = textComponents.get(i);
                mc.fontRenderer.drawString(component.getFormattedText(), x + 8, y + 5 + i * 10, 0xffffff);
            }
        }

        @Override
        public void handleClicked(double mouseX, double mouseY, int mouseButton) {
            Minecraft.getInstance().displayGuiScreen(new NewsScreen(parent, Pubgmc.getContentManager()));
        }
    }

    public static class EventPanelComponent extends Component implements TickableComponent {

        final int count;
        short timer = 100;
        int currentMsg = 0;
        private final List<Component> msgComponents = new ArrayList<>();
        private final List<Component> children = new ArrayList<>();

        public EventPanelComponent(int x, int y, int width, int height) {
            super(x, y, width, height);
            this.count = getMessageCount();
            if(count > 0) {
                Optional<MenuDisplayContent[]> optional = allContent();
                optional.ifPresent(arr -> {
                    for(MenuDisplayContent mdc : arr) {
                        msgComponents.add(mdc.createComponent(x + 4, y + 15, width - 8, 40));
                    }
                });
            }
            updateChilds();
        }

        @Override
        public void handleClicked(double mouseX, double mouseY, int mouseButton) {
            for (Component component : children) {
                if(component.isMouseOver(mouseX, mouseY)) {
                    component.handleClicked(mouseX, mouseY, mouseButton);
                    return;
                }
            }
        }

        public void updateChilds() {
            children.clear();
            if(count > 1) {
                children.add(msgComponents.get(currentMsg));
            }
            boolean canFitAll = (width - 8) / 10 > count;
            if(canFitAll) {
                for (int i = 0; i < count; i++) {
                    int px = x + 4 + i * 10;
                    int py = y + height - 9;
                    children.add(new MessageIndicatorComponent(i, this, px, py, 5, 5));
                }
            }
        }

        @Override
        public void tickComponent() {
            if(count > 1) {
                if(--timer <= 0) {
                    timer = 100;
                    int nm = currentMsg + 1;
                    currentMsg = nm >= count ? 0 : nm;
                    updateChilds();
                }
            }
        }

        @Override
        public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            RenderHelper.drawColoredShape(x, y, x + width, y + height, 0.0F, 0.0F, 0.0F, 0.5F);
            FontRenderer renderer = mc.fontRenderer;
            renderer.drawString(TextFormatting.BOLD + "Events & Announcements", x + 4, y + 4, 0xffffff);
            if(count > 0) {
                msgComponents.get(currentMsg).draw(mc, mouseX, mouseY, partialTicks);
            } else {
                String text = TextFormatting.BOLD + "No events";
                renderer.drawStringWithShadow(text, x + (width - renderer.getStringWidth(text)) / 2.0F, y + (height - renderer.FONT_HEIGHT) / 2.0F, 0xff3333);
            }
            for (Component child : children) {
                child.draw(mc, mouseX, mouseY, partialTicks);
            }
        }

        int getMessageCount() {
            ContentResult cr = Pubgmc.getContentManager().getCachedResult();
            if(cr != null) {
                return cr.getMenuDisplayContents().length;
            }
            return 0;
        }

        Optional<MenuDisplayContent[]> allContent() {
            ContentManager contentManager = Pubgmc.getContentManager();
            ContentResult result = contentManager.getCachedResult();
            if(result == null) {
                return Optional.empty();
            } else return Optional.ofNullable(result.getMenuDisplayContents());
        }

        public void setCurrentMsg(int i) {
            timer = 100;
            currentMsg = i;
            updateChilds();
        }

        public int getCurrentMsg() {
            return currentMsg;
        }

        static class MessageIndicatorComponent extends PressableComponent {

            final boolean selected;

            public MessageIndicatorComponent(int messageID, EventPanelComponent eventComponent, int x, int y, int width, int height) {
                super(x, y, width, height, component -> eventComponent.setCurrentMsg(messageID));
                selected = eventComponent.currentMsg == messageID;
            }

            @Override
            public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
                RenderHelper.drawColoredShape(x, y, x + width, y + height, 1.0F, 1.0F, 1.0F, 1.0F);
                if(!selected) {
                    RenderHelper.drawColoredShape(x + 1, y + 1, x + width - 1, y + height - 1, 0.0F, 0.0F, 0.0F, 1.0F);
                }
            }
        }
    }

    static class LinkImageComponent extends ImagePressableComponent {

        final Screen parent;
        final String link;
        @Nullable String info;
        boolean notify;

        LinkImageComponent(int x, int y, int width, int height, ResourceLocation texture, String link, Screen parent) {
            super(x, y, width, height, texture, null);
            this.parent = parent;
            this.link = link;
        }

        LinkImageComponent notificationOn(boolean notify) {
            this.notify = notify;
            return this;
        }

        public LinkImageComponent withInfo(String info) {
            this.info = info;
            return this;
        }

        @Override
        public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
            super.draw(mc, mouseX, mouseY, partialTicks);
            if(notify) {
                long time = System.currentTimeMillis() % 2000L;
                boolean flag = time >= 1000L;
                float f = flag ? 1.0F : 0.0F;
                RenderHelper.drawColoredShape(x + width - 4, y, x + width, y + 4, f, f, f, 1.0F);
                RenderHelper.drawColoredShape(x + width - 3, y + 1, x + width - 1, y + 3, 1.0F, 1.0F, 0.0F, 1.0F);
            }
            if(info != null && isMouseOver(mouseX, mouseY)) {
                FontRenderer renderer = mc.fontRenderer;
                String astring = notify ? info + " - Update available" : info;
                int tw = renderer.getStringWidth(astring);
                RenderHelper.drawColoredShape(x + 10, y - 11, x + 16 + tw, y, 0.0F, 0.0F, 0.0F, 1.0F);
                renderer.drawString(astring, x + 13, y - 9, 0xffffff);
            }
        }

        @Override
        public void handleClicked(double mouseX, double mouseY, int mouseButton) {
            if(mouseButton == 0 && isEnabled()) {
                playPressSound();
                Minecraft mc = Minecraft.getInstance();
                mc.displayGuiScreen(new ConfirmOpenLinkScreen(f -> {
                    if(f) Util.getOSType().openURI(link);
                    mc.displayGuiScreen(parent);
                }, link, true));
            }
        }
    }
}
