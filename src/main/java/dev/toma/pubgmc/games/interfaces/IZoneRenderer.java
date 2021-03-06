package dev.toma.pubgmc.games.interfaces;

import com.mojang.blaze3d.platform.GlStateManager;
import dev.toma.pubgmc.capability.world.WorldDataProvider;
import dev.toma.pubgmc.games.Game;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

import javax.vecmath.Vector2d;

@OnlyIn(Dist.CLIENT)
public interface IZoneRenderer {

    IZoneRenderer BASIC = new BasicZoneRenderer();
    IZoneRenderer MOVING = new MovingZoneRenderer();

    void doRender(IZone zone, float partialTicks);

    class BasicZoneRenderer implements IZoneRenderer {

        @Override
        public void doRender(IZone zone, float partialTicks) {
            Minecraft mc = Minecraft.getInstance();
            Entity entity = mc.getRenderViewEntity();
            ActiveRenderInfo renderInfo = mc.gameRenderer.activeRender;
            double intX = renderInfo.getProjectedView().x;
            double intY = renderInfo.getProjectedView().y;
            double intZ = renderInfo.getProjectedView().z;
            mc.world.getCapability(WorldDataProvider.CAP).ifPresent(cap -> {
                double maxRenderDist = mc.gameSettings.renderDistanceChunks * 16;
                if(this.isClose(entity, zone, maxRenderDist)) {
                    GlStateManager.pushMatrix();
                    GlStateManager.translated(-intX, -intY, -intZ);
                    Tessellator tessellator = Tessellator.getInstance();
                    BufferBuilder builder = tessellator.getBuffer();
                    Game game = cap.getGame();
                    float r = 0.0F;
                    float g = 0.2F;
                    float b = 0.8F;
                    float a = 0.35F;
                    double px1 = xGetMin(zone, partialTicks);
                    double px2 = xGetMax(zone, partialTicks);
                    double pz1 = zGetMin(zone, partialTicks);
                    double pz2 = zGetMax(zone, partialTicks);
                    double maxY = intY + 70.0D;
                    double minY = intY - 70.0D;
                    double minPosZ = Math.max(Math.floor(intZ - maxRenderDist), pz1);
                    double maxPosZ = Math.min(Math.ceil(intZ + maxRenderDist), pz2);
                    double minPosX = Math.max(Math.floor(intX - maxRenderDist), px1);
                    double maxPosX = Math.min(Math.ceil(intX + maxRenderDist), px2);
                    builder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
                    GlStateManager.enableBlend();
                    GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    GlStateManager.disableCull();
                    GlStateManager.disableTexture();
                    if(intX > px2 - maxRenderDist) {
                        builder.pos(px2, maxY, minPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px2, maxY, maxPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px2, minY, maxPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px2, minY, minPosZ).color(r, g, b, a).endVertex();
                    }
                    if(intX < px1 + maxRenderDist) {
                        builder.pos(px1, maxY, minPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px1, maxY, maxPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px1, minY, maxPosZ).color(r, g, b, a).endVertex();
                        builder.pos(px1, minY, minPosZ).color(r, g, b, a).endVertex();
                    }
                    if(intZ > pz2 - maxRenderDist) {
                        builder.pos(minPosX, maxY, pz2).color(r, g, b, a).endVertex();
                        builder.pos(maxPosX, maxY, pz2).color(r, g, b, a).endVertex();
                        builder.pos(maxPosX, minY, pz2).color(r, g, b, a).endVertex();
                        builder.pos(minPosX, minY, pz2).color(r, g, b, a).endVertex();
                    }
                    if(intZ < pz1 + maxRenderDist) {
                        builder.pos(minPosX, maxY, pz1).color(r, g, b, a).endVertex();
                        builder.pos(maxPosX, maxY, pz1).color(r, g, b, a).endVertex();
                        builder.pos(maxPosX, minY, pz1).color(r, g, b, a).endVertex();
                        builder.pos(minPosX, minY, pz1).color(r, g, b, a).endVertex();
                    }
                    builder.sortVertexData((float) entity.posX, (float) entity.posY, (float) entity.posZ);
                    tessellator.draw();
                    GlStateManager.enableTexture();
                    GlStateManager.enableCull();
                    GlStateManager.disableBlend();
                    game.renderInWorldStuff(tessellator, builder, cap, partialTicks);
                    GlStateManager.popMatrix();
                }
            });
        }

        protected double xGetMin(IZone zone, float partialTicks) {
            return zone.getMin().x;
        }

        protected double zGetMin(IZone zone, float partialTicks) {
            return zone.getMin().y;
        }

        protected double xGetMax(IZone zone, float partialTicks) {
            return zone.getMax().x;
        }

        protected double zGetMax(IZone zone, float partialTicks) {
            return zone.getMax().y;
        }

        protected static double interpolate(double at, double prev, float partial) {
            return prev + (at - prev) * partial;
        }

        protected boolean isClose(Entity entity, IZone zone, double maxDist) {
            Vector2d min = zone.getMin();
            Vector2d max = zone.getMax();
            return entity.posX >= max.x - maxDist || entity.posX <= min.x + maxDist || entity.posZ >= max.y - maxDist || entity.posZ <= max.y + maxDist;
        }
    }

    class MovingZoneRenderer extends BasicZoneRenderer {

        @Override
        protected double xGetMin(IZone zone, float partialTicks) {
            return interpolate(zone.getMin().x, zone.getMinLast().x, partialTicks);
        }

        @Override
        protected double xGetMax(IZone zone, float partialTicks) {
            return interpolate(zone.getMax().x, zone.getMaxLast().x, partialTicks);
        }

        @Override
        protected double zGetMin(IZone zone, float partialTicks) {
            return interpolate(zone.getMin().y, zone.getMinLast().y, partialTicks);
        }

        @Override
        protected double zGetMax(IZone zone, float partialTicks) {
            return interpolate(zone.getMax().y, zone.getMaxLast().y, partialTicks);
        }
    }
}
