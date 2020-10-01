package dev.toma.pubgmc.client.animation.gun;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.toma.pubgmc.client.animation.types.AimingAnimation;
import dev.toma.pubgmc.common.item.gun.GunItem;
import dev.toma.pubgmc.util.AttachmentHelper;
import net.minecraft.item.ItemStack;

public abstract class AnimationPackPistols extends GunAnimationPack {

    @Override
    public void applyOnLeftArm() {
        GlStateManager.translatef(0.45F, -0.2F, 0.1F);
        GlStateManager.rotatef(-30.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotatef(10.0F, 1.0F, 0.0F, 0.0F);
    }

    @Override
    public void applyOnRightArm() {
        GlStateManager.translatef(0.35F, -0.15F, 0.3F);
        GlStateManager.rotatef(10.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotatef(10.0F, 1.0F, 0.0F, 0.0F);
    }

    @Override
    public AimingAnimation getAimingAnimation(GunItem item, ItemStack stack) {
        return new AimingAnimation(-0.56F, this.getAimYOffset(item, stack), 0.0F).right(f -> {
            GlStateManager.translatef(-0.4F * f, 0.125F * f, 0.1F * f);
            GlStateManager.rotatef(10.0F * f, 0.0F, 1.0F, 0.0F);
        }).left(f -> {
            GlStateManager.translatef(-0.35F * f, 0.125F * f, 0.2F * f);
            GlStateManager.rotatef(15.0F * f, 0.0F, 1.0F, 0.0F);
        });
    }

    public float getAimYOffset(GunItem item, ItemStack stack) {
        if(AttachmentHelper.hasRedDot(item, stack)) {
            return 0.067F;
        }
        return 0.1F;
    }
}