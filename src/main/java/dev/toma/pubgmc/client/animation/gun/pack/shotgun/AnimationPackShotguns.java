package dev.toma.pubgmc.client.animation.gun.pack.shotgun;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.toma.pubgmc.client.animation.gun.ReloadAnimation;
import dev.toma.pubgmc.client.animation.gun.pack.GunAnimationPack;
import dev.toma.pubgmc.client.animation.gun.pack.pistol.AnimationPackPistols;
import dev.toma.pubgmc.client.animation.types.AimingAnimation;
import dev.toma.pubgmc.common.item.gun.core.AbstractGunItem;
import net.minecraft.item.ItemStack;

public abstract class AnimationPackShotguns extends GunAnimationPack {

    @Override
    public void applyOnRightArm() {
        GlStateManager.translatef(0.0F, 0.0F, 0.7F);
    }

    @Override
    public void applyOnLeftArm() {
        GlStateManager.translatef(0.45F, -0.1F, -0.2F);
        GlStateManager.rotatef(-15.0F, 0.0F, 1.0F, 0.0F);
    }

    @Override
    public float getAimYOffset(AbstractGunItem item, ItemStack stack) {
        return 0.16F;
    }

    @Override
    public AimingAnimation getAimingAnimation(AbstractGunItem gunItem, ItemStack stack) {
        return new AimingAnimation(-0.41F, this.getAimYOffset(gunItem, stack), 0.0F).left(f -> {
            GlStateManager.translatef(-0.3F * f, 0.1F * f, 0.15F * f);
            GlStateManager.rotatef(2.0F * f, 0.0F, 1.0F, 0.0F);
        });
    }

    @Override
    public ReloadAnimation getReloadAnimation(AbstractGunItem gunItem, ItemStack stack, boolean isContinued) {
        return new AnimationPackPistols.PistolDefaultReloadAnimation(gunItem, stack);
    }
}
