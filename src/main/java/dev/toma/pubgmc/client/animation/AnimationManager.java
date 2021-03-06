package dev.toma.pubgmc.client.animation;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.util.object.Optional;
import net.minecraftforge.event.TickEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

public class AnimationManager {

    private static final Map<AnimationType, Animation> ACTIVE_ANIMATIONS = new HashMap<>();

    public static void playNewAnimation(AnimationType type, @Nonnull Animation animation) {
        if(animation == null) {
            Pubgmc.pubgmcLog.fatal("Attempted to play 'null' animation with id {}, canceling...", type.index);
            return;
        }
        type.apply();
        ACTIVE_ANIMATIONS.put(type, animation);
    }

    public static void stopAnimation(AnimationType type) {
        ACTIVE_ANIMATIONS.remove(type);
    }

    public static boolean isAnimationActive(AnimationType type) {
        return ACTIVE_ANIMATIONS.get(type) != null;
    }

    public static boolean isAnimationActive(AnimationType type, Predicate<Animation> condition) {
        Animation animation = ACTIVE_ANIMATIONS.get(type);
        return animation != null && condition.test(animation);
    }

    public static Optional<Animation> getAnimationFromID(AnimationType type) {
        return Optional.of(ACTIVE_ANIMATIONS.get(type));
    }

    public static void animateItemAndHands(float partialTicks) {
        ACTIVE_ANIMATIONS.values().forEach(Animation::animateItemAndHands);
    }

    public static void animateHands(float partialTicks) {
        ACTIVE_ANIMATIONS.values().forEach(Animation::animateHands);
    }

    public static void animateRightHand(float partialTicks) {
        ACTIVE_ANIMATIONS.values().forEach(Animation::animateRightHand);
    }

    public static void animateLeftHand(float partialTicks) {
        ACTIVE_ANIMATIONS.values().forEach(Animation::animateLeftHand);
    }

    public static void animateItem(float partialTicks) {
        ACTIVE_ANIMATIONS.values().forEach(Animation::animateItem);
    }

    public static boolean isItemRenderCanceled() {
        for(Animation animation : ACTIVE_ANIMATIONS.values()) {
            if(animation.shouldCancelItemRendering()) return true;
        }
        return false;
    }

    public static void renderTick(float partialTicks, TickEvent.Phase phase) {
        ACTIVE_ANIMATIONS.values().forEach(a -> a.renderTick(partialTicks, phase));
    }

    public static void clientTick() {
        Iterator<Map.Entry<AnimationType, Animation>> iterator = ACTIVE_ANIMATIONS.entrySet().iterator();
        while (iterator.hasNext()) {
            Animation animation = iterator.next().getValue();
            animation.clientTick();
            if(animation.isAnimationFinished()) {
                iterator.remove();
            }
        }
    }
}
