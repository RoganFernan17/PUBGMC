package dev.toma.pubgmc.common.entity.vehicle;

import dev.toma.pubgmc.Registry;
import dev.toma.pubgmc.util.RenderHelper;
import dev.toma.pubgmc.util.UsefulFunctions;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AirDriveableEntity extends DriveableEntity {

    public float throttle = 0.0F;

    public AirDriveableEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    public AirDriveableEntity(EntityType<?> type, World world, BlockPos pos, DriveableData data) {
        super(type, world, pos, data);
    }

    @Override
    public void setBaseData() {
        this.health = data.getMaxHealth();
        this.fuel = 0.0F;
    }

    @Override
    protected void updateEntityPost() {
        if(onGround && (rotationPitch > 0 || currentSpeed == 0)) rotationPitch = 0;
        this.currentSpeed = throttle > 0.0F ? currentSpeed < this.maxSpeed() ? currentSpeed + throttle * data.getAcceleration() : Math.max(0.0F, currentSpeed - (onGround ? 0.05F : 0.005F)) : Math.max(0.0F, currentSpeed - (onGround ? 0.05F : 0.005F));
        if(!onGround) this.currentSpeed = rotationPitch > 0 ? currentSpeed + 0.01F : rotationPitch < 0 ? currentSpeed - 0.001F : currentSpeed;
        if(this.posY > 128) this.rotationPitch += 1.5F;
        this.setMotion(this.getMotion().x, currentSpeed > 0.3F ? this.getMotion().y : -0.25, this.getMotion().z);
        move(MoverType.SELF, this.getMotion());
        if(!this.isBeingRidden()) {
            resetInputState();
            throttle = Math.max(0.0F, throttle - 0.025F);
        }
    }

    @Override
    protected void updateMovement() {
        if(forwardKey && !backwardKey) {
            this.moveForward();
        }
        if(!forwardKey && backwardKey) {
            this.moveBackward();
        }
        if(rightKey && !leftKey) {
            this.moveRight();
        }
        if(!rightKey && leftKey) {
            this.moveLeft();
        }
        if(rotorAccelerate && !rotorSlowndown) {
            this.onRotorAccelerate();
        }
        if(!rotorAccelerate && rotorSlowndown) {
            this.onRotorSlowndown();
        }
        if(noRotateKey()) {
            if(noRotateKey()) {
                float rotationSpeedSlowdown = 1.0f;
                turnModifier = Math.abs(turnModifier - rotationSpeedSlowdown) <= rotationSpeedSlowdown ? 0.0F : turnModifier > 0 ? turnModifier - rotationSpeedSlowdown : turnModifier < 0 ? turnModifier + rotationSpeedSlowdown : 0.0F;
            }
        }
        this.rotationYaw += turnModifier;
        Vec3d lookVec = this.getLookVec();
        this.setMotion(lookVec.mul(currentSpeed, currentSpeed, currentSpeed));
    }

    // pitchDown
    @Override
    protected void moveForward() {
        if(!onGround) rotationPitch = UsefulFunctions.wrap(rotationPitch + 1.0F, -15.0F, 15.0F);
    }

    // pitchUp
    @Override
    protected void moveBackward() {
        if(currentSpeed > 0.3F) rotationPitch = UsefulFunctions.wrap(rotationPitch - 1.0F, -15.0F, 15.0F);
    }

    @Override
    protected void onRotorAccelerate() {
        if(hasFuel() && submergedHeight < 1.0D) throttle = Math.min(1.0F, throttle + 0.04F);
    }

    @Override
    protected void onRotorSlowndown() {
        throttle = Math.max(0.0F, throttle - 0.04F);
    }

    private float maxSpeed() {
        return data.getMaxSpeed() * throttle;
    }

    public static class GliderDriveable extends AirDriveableEntity {
        public static final DriveableData DATA = new DriveableData(50F, 100.0F, 1.4F, 0.01F, 0.2F);
        public GliderDriveable(EntityType<?> type, World world) {
            super(type, world);
        }
        public GliderDriveable(World world, BlockPos pos) {
            super(Registry.PMCEntityTypes.GLIDER, world, pos, DATA);
        }
        @Override
        public int maxUserAmount() {
            return 2;
        }
        @OnlyIn(Dist.CLIENT)
        @Override
        public void drawOnScreen(Minecraft mc, MainWindow window) {
            int x = window.getScaledWidth() / 2;
            int start = x + 120;
            int top = window.getScaledHeight() - 190;
            RenderHelper.drawColoredShape(start, top, start + 16, top + 100, 0.0F, 0.0F, 0.0F, 0.5F);
            int size = (int)(throttle * 100);
            RenderHelper.drawColoredShape(start, top + 100 - size, start + 16, top + 100, 1.0F, 1.0F, 1.0F, 1.0F);
            mc.fontRenderer.drawStringWithShadow("PW", start + 2, top + 104, 0xffffff);
            RenderHelper.drawColoredShape(x - 128, top, x - 112, top + 100, 0.0F, 0.0F, 0.0F, 0.5F);
            int groundLevel = mc.world.getHeight(Heightmap.Type.WORLD_SURFACE, (int) posX, (int) posZ);
            int barY = (int)(groundLevel / 128.0F * 100);
            RenderHelper.drawColoredShape(x - 128, top + 100 - barY, x - 112, top + 100 - barY + 1, 0.0F, 0.7F, 0.0F, 1.0F);
            int pBarY = (int)(posY / 128.0F * 100);
            RenderHelper.drawColoredShape(x - 128, top + 100 - pBarY, x - 112, top + 100 - pBarY + 1, 1.0F, 1.0F, 1.0F, 1.0F);
            mc.fontRenderer.drawStringWithShadow((int)posY + "m", x - 110, top + 100 - pBarY - 3, 0xFFFFFF);
            if(pBarY - barY > 8) mc.fontRenderer.drawStringWithShadow(groundLevel + "m", x - 110, top + 100 - barY - 3, 0x00AA00);
        }
        @Override
        protected double getPassengerX(int index) {
            return index == 0 ? -0.5 : -1.5;
        }
        @Override
        protected double getPassengerY(int index) {
            return index == 0 ? 0.4 : 0.8;
        }
        @Override
        protected double getPassengerZ(int index) {
            return 0;
        }
    }
}
