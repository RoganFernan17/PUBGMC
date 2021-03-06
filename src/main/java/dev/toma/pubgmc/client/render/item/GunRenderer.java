package dev.toma.pubgmc.client.render.item;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.client.model.gun.*;
import dev.toma.pubgmc.client.model.gun.attachment.*;
import dev.toma.pubgmc.common.item.gun.core.AbstractGunItem;
import dev.toma.pubgmc.internal.attachment.AttachmentSettings;
import dev.toma.pubgmc.util.AttachmentHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class GunRenderer extends ItemStackTileEntityRenderer {

    // attachments models
    public static final AttachmentModel SMG_SUPPRESSOR = new SMGSuppressorModel();
    public static final AttachmentModel AR_SUPPRESSOR = new ARSuppressorModel();
    public static final AttachmentModel SR_SUPPRESSOR = new SRSuppressorModel();
    public static final AttachmentModel RED_DOT = new RedDotModel();
    public static final AttachmentModel HOLO = new HolographicModel();
    public static final AttachmentModel SCOPE_2X = new ScopeX2Model();
    public static final AttachmentModel SCOPE_4X = new ScopeX4Model();
    public static final AttachmentModel SCOPE_8X = new ScopeX8Model();
    public static final AttachmentModel SCOPE_15X = new ScopeX15Model();
    public static final AttachmentModel VERTICAL_GRIP = new VerticalGripModel();
    public static final AttachmentModel ANGLED_GRIP = new AngledGripModel();

    public static final ResourceLocation GUN_TEXTURE_MAP = Pubgmc.makeResource("textures/weapons/gun_texture_map.png");
    public static final ResourceLocation ATTACHMENT_TEXTURE_MAP = Pubgmc.makeResource("textures/weapons/attachment_texture_map.png");

    private final AbstractGunModel model;

    public GunRenderer() {
        this.model = createModel();
    }

    public abstract AbstractGunModel createModel();

    protected abstract void renderAttachments(AbstractGunItem item, ItemStack stack);

    public void offsetModel() {

    }

    public AbstractGunModel getModel() {
        return model;
    }

    @Override
    public void renderByItem(ItemStack itemStackIn) {
        TextureManager manager = Minecraft.getInstance().getTextureManager();
        manager.bindTexture(GUN_TEXTURE_MAP);
        GlStateManager.pushMatrix();
        this.offsetModel();
        GlStateManager.translatef(0.5F, 1.2F, 0.25F);
        GlStateManager.scalef(0.02F, 0.02F, 0.02F);
        GlStateManager.rotatef(180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
        this.getModel().render(itemStackIn);
        GlStateManager.popMatrix();
        this.renderAttachments((AbstractGunItem) itemStackIn.getItem(), itemStackIn);
    }

    /* ============================= RENDERERS ================================== */

    public static class P92Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return new P92Model();
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.scaled(0.65, 0.65, 0.65);
                GlStateManager.translated(0.768, 0.6, 0.5);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.hasSilencer(item, stack)) {
                SMG_SUPPRESSOR.doRender();
            }
        }
    }

    public static class P1911Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return new P1911Model();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(0.0f, 0.07f, 0.0f);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.5F, 0.36000004F, 0.42F);
                GlStateManager.scalef(0.6999999F, 0.6999999F, 0.6999999F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.hasSilencer(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.0F, 0.01F, 0.04F);
                SMG_SUPPRESSOR.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class P18CRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new P18CModel();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(1.0F, 0.09F, 0.55F);
            GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.5F, 0.35000005F, 0.33999997F);
                GlStateManager.scalef(0.6999999F, 0.6999999F, 0.59999985F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.hasSilencer(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(-0.1F, -0.16999999F, 0.04F);
                GlStateManager.scalef(1.2F, 1.2F, 1.0F);
                SMG_SUPPRESSOR.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class DeagleRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new DeagleModel();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(0.123F, -0.01F, 0.35F);
            GlStateManager.scalef(0.75F, 0.75F, 0.75F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.5F, 0.37000003F, 0.34999996F);
                GlStateManager.scalef(0.6999999F, 0.6999999F, 0.6999999F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class R1895Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return new R1895Model();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(-0.002F, -0.005F, 0.0F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasSilencer(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.14999998F, 0.26000002F, -0.17999999F);
                GlStateManager.scalef(0.6999999F, 0.6999999F, 0.6999999F);
                SMG_SUPPRESSOR.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class R45Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return new R45Model();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(-0.002F, 0.01F, 0.0F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.5F, 0.45000005F, 0.15999998F);
                GlStateManager.scalef(0.5999999F, 0.5999999F, 0.5999999F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class ScorpionRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new ScorpionModel();
        }

        @Override
        public void offsetModel() {
            GlStateManager.translatef(-0.002F, -0.345F, 0.2F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.5F, 0.28000003F, 0.38000003F);
                GlStateManager.scalef(0.79999995F, 0.79999995F, 0.79999995F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }

            if(AttachmentHelper.hasSilencer(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.0F, -0.02F, 0.04F);
                SMG_SUPPRESSOR.doRender();
                GlStateManager.popMatrix();
            }

            if(AttachmentHelper.hasVerticalGrip(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.495F, -0.23000005F, 0.19F);
                VERTICAL_GRIP.doRender();
                GlStateManager.popMatrix();
            }
        }
    }

    public static class SawedOffRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new SawedOffModel();
        }

        @Override
        public void offsetModel() {
            GlStateManager.scalef(0.75F, 0.75F, 0.75F);
            GlStateManager.translatef(0.165F, 0.25F, 0.0F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            AttachmentSettings.instance().renderAll();
        }
    }

    public static class S1897Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return new S1897Model();
        }

        @Override
        public void offsetModel() {
            GlStateManager.scalef(1.0F, 1.0F, 0.8F);
            GlStateManager.translatef(-0.15F, -0.1F, 0.5F);
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
        }
    }

    public static class S686Renderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new S686Model();
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }

        @Override
        public void offsetModel() {
            GlStateManager.scalef(1.0F, 1.0F, 0.8F);
            GlStateManager.translatef(-0.15F, -0.18F, 0.5F);
        }
    }

    public static class S12KRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return new S12KModel();
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {
            if(AttachmentHelper.hasRedDot(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.34999993F, 0.21000001F, 0.6F);
                GlStateManager.scalef(0.79999995F, 0.79999995F, 0.79999995F);
                RED_DOT.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.hasHolographic(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.349F, -0.53F, 0.77000004F);
                GlStateManager.scalef(1.8000002F, 1.8000002F, 1.8000002F);
                HOLO.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.has2x(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.35000005F, -0.59999985F, 0.72000015F);
                GlStateManager.scalef(1.9000002F, 1.9000002F, 1.9000002F);
                SCOPE_2X.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.has4x(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.35000005F, -0.29000008F, 0.69000006F);
                GlStateManager.scalef(1.6000001F, 1.6000001F, 1.0F);
                SCOPE_4X.doRender();
                GlStateManager.popMatrix();
            }
            if(AttachmentHelper.hasSilencer(item, stack)) {
                GlStateManager.pushMatrix();
                GlStateManager.translatef(0.35000005F, -0.82000005F, -0.55999994F);
                GlStateManager.scalef(2.0000002F, 2.0000002F, 1.3000001F);
                AR_SUPPRESSOR.doRender();
                GlStateManager.popMatrix();
            }
            AttachmentSettings.instance().renderAll();
        }

        @Override
        public void offsetModel() {
            GlStateManager.rotatef(180.0F, 0.0F, 1.0F, 0.0F);
            GlStateManager.scalef(1.0F, 1.0F, 0.8F);
            GlStateManager.translatef(-0.85F, -0.15F, -0.95F);
        }
    }

    public static class UziRenderer extends GunRenderer {
        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }

    public static class Mp5kRenderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }

    public static class PP19Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }

    public static class VectorRenderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }

    public static class Ump45Renderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }

    public static class ThompsonRenderer extends GunRenderer {

        @Override
        public AbstractGunModel createModel() {
            return null;
        }

        @Override
        protected void renderAttachments(AbstractGunItem item, ItemStack stack) {

        }
    }
}
