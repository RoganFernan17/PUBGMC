package dev.toma.pubgmc.common.entity.vehicle;

import dev.toma.pubgmc.common.entity.IControllableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractControllableEntity extends Entity implements IControllableEntity {

    public boolean forwardKey;
    public boolean backwardKey;
    public boolean rightKey;
    public boolean leftKey;
    public boolean rotorAccelerate;
    public boolean rotorSlowndown;

    public AbstractControllableEntity(EntityType<?> type, World world) {
        super(type, world);
        this.ignoreFrustumCheck = true;
    }

    @Override
    public void onInputUpdate(boolean forward, boolean backward, boolean right, boolean left, boolean rotorAccelerate, boolean rotorSlowndown) {
        this.forwardKey = forward;
        this.backwardKey = backward;
        this.rightKey = right;
        this.leftKey = left;
        this.rotorAccelerate = rotorAccelerate;
        this.rotorSlowndown = rotorSlowndown;
    }

    @Override
    public final void tick() {
        this.updateMovement();
        this.updateEntityPre();
        super.tick();
        this.updateEntityPost();
    }

    @Nullable
    @Override
    public Entity getControllingPassenger() {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : list.get(0);
    }

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
    }

    public Entity collidedWith(Vec3d start, Vec3d end, AxisAlignedBB aabb) {
        return collidedWith(start, end, aabb, entity -> !entity.isSpectator() && entity.isAlive() && entity.canBeCollidedWith() && !isPassenger(entity));
    }

    public Entity collidedWith(Vec3d start, Vec3d end, AxisAlignedBB aabb, Predicate<Entity> filter) {
        double distance = Double.MAX_VALUE;
        Entity entity = null;
        for(Entity e : world.getEntitiesInAABBexcluding(this, aabb, filter)) {
            AxisAlignedBB alignedBB = e.getBoundingBox();
            Optional<Vec3d> optionalVec3d = alignedBB.rayTrace(start, end);
            if(optionalVec3d.isPresent()) {
                Vec3d vec3d = optionalVec3d.get();
                double distanceToEntity = start.squareDistanceTo(vec3d);
                if(distanceToEntity < distance) {
                    entity = e;
                    distance = distanceToEntity;
                }
            }
        }
        return entity;
    }

    /** Called before {@link Entity#tick()} is called */
    protected void updateEntityPre() {

    }

    /** Called after {@link Entity#tick()} has been called*/
    protected void updateEntityPost() {

    }

    /** Use this to apply logic when forward key is being held down */
    protected void moveForward() {

    }

    /** Use this to apply logic when backward key is being held down */
    protected void moveBackward() {

    }

    /** Use this to apply logic when right key is being held down */
    protected void moveRight() {

    }

    /** Use this to apply logic when left key is being held down */
    protected void moveLeft() {

    }

    protected void onRotorAccelerate() {

    }

    protected void onRotorSlowndown() {

    }

    protected boolean noKeyInput() {
        return noVerticalKey() && noRotateKey();
    }

    protected boolean noVerticalKey() {
        return !forwardKey && !backwardKey;
    }

    protected boolean noRotateKey() {
        return !rightKey && !leftKey;
    }

    protected void resetInputState() {
        this.forwardKey = false;
        this.backwardKey = false;
        this.rightKey = false;
        this.leftKey = false;
        this.rotorAccelerate = false;
        this.rotorSlowndown = false;
    }
}
