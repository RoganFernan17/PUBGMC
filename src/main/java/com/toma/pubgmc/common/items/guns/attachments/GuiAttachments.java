package com.toma.pubgmc.common.items.guns.attachments;

import com.toma.pubgmc.Pubgmc;
import com.toma.pubgmc.common.items.guns.GunBase;
import com.toma.pubgmc.util.ImageUtil;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class GuiAttachments extends GuiContainer {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    private static final ResourceLocation TEXTURE = new ResourceLocation(Pubgmc.MOD_ID + ":textures/gui/attachmentInv.png");
    private static final ResourceLocation BACKGROUND = new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/base.png");

    public GuiAttachments(InventoryPlayer inventory, EntityPlayer player) {
        super(new ContainerAttachments(inventory, player));
        xSize = 176;
        ySize = 170;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        for (FieldType type : FieldType.values()) {
            fontRenderer.drawStringWithShadow(type.getName(), type.getTextX(), type.getTextY(), 0xFFFFFF);

            if (ITEMS.size() > 6) {
                switch (type.ordinal()) {
                    case 0: {
                        if (ITEMS.get(2) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    case 1: {
                        if (ITEMS.get(3) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    case 2: {
                        if (ITEMS.get(4) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    case 3: {
                        if (ITEMS.get(5) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    case 4: {
                        if (ITEMS.get(1) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    case 5: {
                        if (ITEMS.get(6) == Items.AIR)
                            ImageUtil.drawCustomSizedImage(mc, type.getIcon(), type.getImgX(), type.getImgY(), 16, 16, true);
                        break;
                    }

                    default:
                        break;
                }
            }
        }

        drawAvailableAttachments();
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        mc.renderEngine.bindTexture(TEXTURE);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    private void drawAvailableAttachments() {
        if (!ITEMS.isEmpty() && ITEMS.get(0) instanceof GunBase) {
            GunBase gun = (GunBase) ITEMS.get(0);
            ItemAttachment[] barrel = gun.getBarrelAttachments();
            ItemAttachment[] grip = gun.getGripAttachments();
            ItemAttachment[] mag = gun.getMagazineAttachments();
            ItemAttachment[] stock = gun.getStockAttachments();
            ItemAttachment[] scope = gun.getScopeAttachments();

            short barOff = 17;
            short gripOff = 17;
            short magOff = 10;
            short stockOff = 17;
            short scopeOff = 17;

            // barrel
            if (barrel.length > 0) {
                for (int i = 0; i < barrel.length; i++) {
                    ItemAttachment at = barrel[i];
                    String loc = at.getRegistryName().toString();
                    if (loc.contains("pubgmc:")) loc = loc.replace("pubgmc:", "");
                    ResourceLocation res = new ResourceLocation(Pubgmc.MOD_ID + ":textures/items/" + loc + ".png");
                    ImageUtil.drawCustomSizedImage(mc, BACKGROUND, 16 - barOff, 30, 16, 16, true);
                    ImageUtil.drawCustomSizedImage(mc, res, 16 - barOff, 30, 16, 16, true);
                    barOff += 16;
                }
            }

            //grip
            if (grip.length > 0) {
                for (int i = 0; i < grip.length; i++) {
                    ItemAttachment at = grip[i];
                    String loc = at.getRegistryName().toString();
                    if (loc.contains("pubgmc:")) loc = loc.replace("pubgmc:", "");
                    ResourceLocation res = new ResourceLocation(Pubgmc.MOD_ID + ":textures/items/" + loc + ".png");
                    ImageUtil.drawCustomSizedImage(mc, BACKGROUND, 40 - gripOff, 50, 16, 16, true);
                    ImageUtil.drawCustomSizedImage(mc, res, 40 - gripOff, 50, 16, 16, true);
                    gripOff += 16;
                }
            }

            // magazine
            if (mag.length > 0) {
                for (int i = 0; i < mag.length; i++) {
                    ItemAttachment at = mag[i];
                    String loc = at.getRegistryName().toString();
                    if (loc.contains("pubgmc:")) loc = loc.replace("pubgmc:", "");
                    ResourceLocation res = new ResourceLocation(Pubgmc.MOD_ID + ":textures/items/" + loc + ".png");
                    ImageUtil.drawCustomSizedImage(mc, BACKGROUND, 70 + magOff, 69, 16, 16, true);
                    ImageUtil.drawCustomSizedImage(mc, res, 70 + magOff, 69, 16, 16, true);
                    magOff += 16;
                }
            }

            // stock
            if (stock.length > 0) {
                for (int i = 0; i < stock.length; i++) {
                    ItemAttachment at = stock[i];
                    String loc = at.getRegistryName().toString();
                    if (loc.contains("pubgmc:")) loc = loc.replace("pubgmc:", "");
                    ResourceLocation res = new ResourceLocation(Pubgmc.MOD_ID + ":textures/items/" + loc + ".png");
                    ImageUtil.drawCustomSizedImage(mc, BACKGROUND, 126 + stockOff, 30, 16, 16, true);
                    ImageUtil.drawCustomSizedImage(mc, res, 126 + stockOff, 30, 16, 16, true);
                    stockOff += 16;
                }
            }

            // scope
            if (scope.length > 0) {
                for (int i = 0; i < scope.length; i++) {
                    ItemAttachment at = scope[i];
                    String loc = at.getRegistryName().toString();
                    if (loc.contains("pubgmc:")) loc = loc.replace("pubgmc:", "");
                    ResourceLocation res = new ResourceLocation(Pubgmc.MOD_ID + ":textures/items/" + loc + ".png");
                    ImageUtil.drawCustomSizedImage(mc, BACKGROUND, 77 - scopeOff, 12, 16, 16, true);
                    ImageUtil.drawCustomSizedImage(mc, res, 77 - scopeOff, 12, 16, 16, true);
                    scopeOff += 16;
                }
            }
        }
    }

    private enum FieldType {
        BARREL(12, 20, 20, 31, "Barrel"),
        GRIP(41, 69, 42, 50, "Grip"),
        MAGAZINE(70, 69, 80, 50, "Magazine"),
        STOCK(118, 20, 124, 31, "Stock"),
        SCOPE(73, 2, 80, 12, "Scope"),
        DETACH(138, 73, 152, 55, "Detach");

        private static final ResourceLocation[] ICONS =
                {
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/barrel.png"),
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/grip.png"),
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/magazine.png"),
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/stock.png"),
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/scope.png"),
                        new ResourceLocation(Pubgmc.MOD_ID + ":textures/overlay/detach.png")
                };
        private String name;
        private int x, y, x1, y1;

        FieldType(int x, int y, int slotX, int slotY, String name) {
            this.x = x;
            this.y = y;
            this.x1 = slotX;
            this.y1 = slotY;
        }

        public String getName() {
            return name;
        }

        public int getTextX() {
            return x;
        }

        public int getTextY() {
            return y;
        }

        public int getImgX() {
            return x1;
        }

        public int getImgY() {
            return y1;
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public ResourceLocation getIcon() {
            return ICONS[ordinal()];
        }
    }
}
