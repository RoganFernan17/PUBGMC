package dev.toma.pubgmc.client.model.gun;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.item.ItemStack;

public class S686Model extends AbstractGunModel {

    private final RendererModel barrels;
    private final RendererModel bone25;
    private final RendererModel bone2;
    private final RendererModel bone11;
    private final RendererModel bone3;
    private final RendererModel bone4;
    private final RendererModel bone7;
    private final RendererModel bone;
    private final RendererModel bone5;
    private final RendererModel bone6;
    private final RendererModel bone8;
    private final RendererModel s686;
    private final RendererModel bone9;
    private final RendererModel bone10;
    private final RendererModel bone16;
    private final RendererModel bone17;
    private final RendererModel bone18;
    private final RendererModel bone19;
    private final RendererModel bone20;
    private final RendererModel bone21;
    private final RendererModel bone24;
    private final RendererModel bone22;
    private final RendererModel bone23;

    @Override
    public void doModelRender(ItemStack stack) {
        s686.render(1.0F);
    }

    public S686Model() {
        textureWidth = 512;
        textureHeight = 512;

        barrels = new RendererModel(this);
        barrels.setRotationPoint(0.0F, 17.48F, 4.224F);
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -0.8452F, -0.433F, -5.9115F, 2, 2, 10, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -1.1548F, -0.433F, -5.9115F, 1, 2, 10, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -3.2456F, -7.9115F, 4, 3, 12, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -3.2456F, -19.9115F, 4, 3, 12, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.2456F, -15.9115F, 4, 3, 7, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.2456F, -8.9115F, 4, 3, 10, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.4855F, -5.6892F, 4, 1, 12, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.2456F, 1.0885F, 4, 3, 5, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.015F, 6.1079F, 4, 3, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -0.8452F, -0.433F, -19.9115F, 2, 2, 14, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -1.1548F, -0.433F, -19.9115F, 1, 2, 14, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -5.2456F, -16.9115F, 4, 2, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -4.2456F, -17.9115F, 4, 1, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.4855F, -15.6892F, 4, 1, 10, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -2.0F, -6.4855F, 6.1079F, 4, 1, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 141, -0.5F, -7.3995F, -56.5834F, 1, 1, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, 7.1041F, 1, 1, 2, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -5.5492F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -5.5492F, 7.1041F, 1, 1, 2, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 138, 77, -1.134F, -6.0492F, 6.2641F, 2, 2, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -4.1831F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -4.1831F, 7.1041F, 1, 1, 2, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -5.5492F, -58.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -5.5492F, 7.1041F, 1, 1, 2, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -2.712F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -2.7121F, 4.1041F, 1, 1, 5, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -1.346F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -1.346F, 4.1041F, 1, 1, 5, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.134F, -1.846F, 6.2641F, 2, 2, 1, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, 0.02F, -58.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, 0.02F, 4.1041F, 1, 1, 5, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -1.346F, -58.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -1.346F, 4.1041F, 1, 1, 5, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -1.346F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -2.712F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -5.5492F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, -28.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, -13.8959F, 1, 1, 11, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -6.9152F, -2.8959F, 1, 1, 10, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -2.712F, -28.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -1.346F, -28.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, 0.02F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, 0.02F, -28.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -5.5492F, -43.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -5.5492F, -28.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -1.346F, -28.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -1.866F, -1.346F, -43.724F, 1, 1, 15, 0.0F, true));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -4.1831F, -43.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, 0.866F, -5.5492F, -28.724F, 1, 1, 15, 0.0F, false));
        barrels.cubeList.add(new ModelBox(barrels, 0, 0, -0.5F, -4.1831F, -28.724F, 1, 1, 15, 0.0F, false));

        bone25 = new RendererModel(this);
        bone25.setRotationPoint(0.0F, 6.52F, -4.224F);
        barrels.addChild(bone25);
        bone25.cubeList.add(new ModelBox(bone25, 0, 0, -1.0F, -8.3438F, -18.9219F, 2, 2, 1, 0.0F, false));
        bone25.cubeList.add(new ModelBox(bone25, 0, 0, -1.0F, -12.5625F, -18.9219F, 2, 2, 1, 0.0F, false));

        bone2 = new RendererModel(this);
        bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone25.addChild(bone2);


        bone11 = new RendererModel(this);
        bone11.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone2.addChild(bone11);
        setRotationAngle(bone11, -0.6981F, 0.0F, 0.0F);
        bone11.cubeList.add(new ModelBox(bone11, 0, 141, -0.5F, 22.3502F, -48.2909F, 1, 1, 1, 0.0F, false));

        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone25.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.0F, -0.5236F);
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -5.5131F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 4.549F, -6.8792F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 1.817F, -6.8792F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -8.2452F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -5.5131F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 4.549F, -6.8792F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 1.817F, -6.8792F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -8.2452F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -5.5131F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -5.5131F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 4.549F, -6.8792F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 4.549F, -6.8792F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 1.817F, -6.8792F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 1.817F, -6.8792F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -8.2452F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.183F, -8.2452F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -9.1532F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -9.1532F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.6506F, -10.5192F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.6506F, -10.5192F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.9185F, -10.5192F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.9186F, -10.5192F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, -54.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -9.1532F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.6506F, -10.5192F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.9185F, -10.5192F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, -39.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -9.1532F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 6.6506F, -10.5192F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 3.9185F, -10.5192F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, -24.5F, 1, 1, 15, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, -9.6719F, 1, 1, 11, 0.0F, false));
        bone3.cubeList.add(new ModelBox(bone3, 0, 0, 5.2846F, -11.8852F, 1.3281F, 1, 1, 10, 0.0F, false));

        bone4 = new RendererModel(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone25.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, -1.0472F);
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -2.817F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 4.5131F, -4.183F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -5.549F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 7.2452F, -4.183F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -2.817F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 4.5131F, -4.183F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -5.549F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 7.2452F, -4.183F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -2.817F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -2.817F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 4.5131F, -4.183F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 4.5131F, -4.183F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -5.549F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 5.8792F, -5.549F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 7.2452F, -4.183F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 7.2452F, -4.183F, 8.3281F, 1, 1, 5, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -4.9185F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -4.9186F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 8.1532F, -6.2846F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 8.1532F, -6.2846F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -7.6506F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -7.6506F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, -54.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, 11.3281F, 1, 1, 2, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -4.9185F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 8.1532F, -6.2846F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -7.6506F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, -39.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -4.9185F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 8.1532F, -6.2846F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 9.5192F, -7.6506F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, -24.5F, 1, 1, 15, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, -9.6719F, 1, 1, 11, 0.0F, false));
        bone4.cubeList.add(new ModelBox(bone4, 0, 0, 10.8852F, -6.2846F, 1.3281F, 1, 1, 10, 0.0F, false));

        bone7 = new RendererModel(this);
        bone7.setRotationPoint(0.0F, -1.1831F, -16.4115F);
        barrels.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 0.4363F);
        bone7.cubeList.add(new ModelBox(bone7, 138, 77, 1.2088F, 0.0044F, -3.5F, 1, 2, 14, 0.0F, true));
        bone7.cubeList.add(new ModelBox(bone7, 138, 77, 1.2088F, 0.0044F, 10.5F, 1, 2, 10, 0.0F, true));

        bone = new RendererModel(this);
        bone.setRotationPoint(0.0F, -1.1831F, -17.4115F);
        barrels.addChild(bone);
        setRotationAngle(bone, 1.1345F, 0.0F, 0.0F);
        bone.cubeList.add(new ModelBox(bone, 138, 77, -1.999F, -3.1374F, 0.8127F, 4, 2, 3, 0.0F, false));
        bone.cubeList.add(new ModelBox(bone, 138, 77, -1.999F, 17.8818F, 8.2366F, 4, 2, 3, 0.0F, false));

        bone5 = new RendererModel(this);
        bone5.setRotationPoint(0.0F, -1.1831F, -17.4115F);
        barrels.addChild(bone5);
        setRotationAngle(bone5, 0.1745F, 0.0F, 0.0F);
        bone5.cubeList.add(new ModelBox(bone5, 138, 77, -2.001F, -4.9227F, -0.3831F, 4, 2, 3, 0.0F, false));

        bone6 = new RendererModel(this);
        bone6.setRotationPoint(0.0F, -1.1831F, -16.4115F);
        barrels.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.4363F);
        bone6.cubeList.add(new ModelBox(bone6, 138, 77, -2.2088F, 0.0044F, -3.5F, 1, 2, 14, 0.0F, false));
        bone6.cubeList.add(new ModelBox(bone6, 138, 77, -2.2088F, 0.0044F, 10.5F, 1, 2, 10, 0.0F, false));

        bone8 = new RendererModel(this);
        bone8.setRotationPoint(0.0F, -1.1831F, -6.4115F);
        barrels.addChild(bone8);
        setRotationAngle(bone8, 0.4363F, 0.0F, 0.0F);
        bone8.cubeList.add(new ModelBox(bone8, 138, 77, -2.001F, 2.0533F, 10.0269F, 4, 2, 3, 0.0F, true));

        s686 = new RendererModel(this);
        s686.setRotationPoint(0.0F, 24.0F, 0.0F);
        s686.cubeList.add(new ModelBox(s686, 0, 86, -1.964F, -10.9725F, 8.3319F, 1, 4, 5, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -1.964F, -9.9725F, 1.3319F, 1, 2, 7, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, 0.964F, -10.9725F, 8.3319F, 1, 4, 5, 0.0F, true));
        s686.cubeList.add(new ModelBox(s686, 0, 86, 0.964F, -9.9725F, 1.3319F, 1, 2, 7, 0.0F, true));
        s686.cubeList.add(new ModelBox(s686, 0, 86, 1.0F, -12.9725F, 11.3319F, 1, 3, 3, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -12.9725F, 11.3319F, 1, 3, 3, 0.0F, true));
        s686.cubeList.add(new ModelBox(s686, 0, 180, -1.0F, -13.6756F, 13.3319F, 2, 1, 2, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -9.9725F, 13.3319F, 4, 4, 1, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -11.9725F, 14.3319F, 4, 6, 6, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -0.6428F, -12.7386F, 14.3319F, 2, 1, 5, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -1.3572F, -12.7386F, 14.3319F, 1, 1, 5, 0.0F, true));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -8.9725F, 20.3319F, 4, 3, 7, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -6.5507F, 31.035F, 4, 4, 8, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -9.2032F, 35.6189F, 4, 5, 6, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.0F, -9.2032F, 41.6189F, 4, 7, 3, 0.0F, false));
        s686.cubeList.add(new ModelBox(s686, 0, 86, -2.5F, -9.7032F, 44.6189F, 5, 10, 1, 0.0F, false));

        bone9 = new RendererModel(this);
        bone9.setRotationPoint(0.8594F, -13.41F, -1.6681F);
        s686.addChild(bone9);
        setRotationAngle(bone9, 0.0F, 0.0F, 0.3491F);
        bone9.cubeList.add(new ModelBox(bone9, 0, 180, -0.6697F, -0.6033F, 15.0F, 1, 1, 2, 0.0F, false));

        bone10 = new RendererModel(this);
        bone10.setRotationPoint(-0.8594F, -13.41F, -1.6681F);
        s686.addChild(bone10);
        setRotationAngle(bone10, 0.0F, 0.0F, -0.3491F);
        bone10.cubeList.add(new ModelBox(bone10, 0, 180, -0.3303F, -0.6033F, 15.0F, 1, 1, 2, 0.0F, true));

        bone16 = new RendererModel(this);
        bone16.setRotationPoint(0.0F, -16.4725F, -1.1681F);
        s686.addChild(bone16);
        setRotationAngle(bone16, 0.0F, 0.0F, 0.8727F);
        bone16.cubeList.add(new ModelBox(bone16, 0, 86, 3.7328F, 1.3605F, 15.5F, 1, 1, 5, 0.0F, false));

        bone17 = new RendererModel(this);
        bone17.setRotationPoint(0.0F, -16.4725F, -1.1681F);
        s686.addChild(bone17);
        setRotationAngle(bone17, 0.0F, 0.0F, -0.8727F);
        bone17.cubeList.add(new ModelBox(bone17, 0, 86, -4.7328F, 1.3605F, 15.5F, 1, 1, 5, 0.0F, true));

        bone18 = new RendererModel(this);
        bone18.setRotationPoint(0.0F, -8.0F, 0.0F);
        s686.addChild(bone18);
        setRotationAngle(bone18, -0.5236F, 0.0F, 0.0F);
        bone18.cubeList.add(new ModelBox(bone18, 0, 86, -2.0F, -11.4723F, 9.9255F, 4, 1, 2, 0.0F, false));

        bone19 = new RendererModel(this);
        bone19.setRotationPoint(0.0F, -8.0F, 0.0F);
        s686.addChild(bone19);
        setRotationAngle(bone19, -0.8727F, 0.0F, 0.0F);
        bone19.cubeList.add(new ModelBox(bone19, 0, 86, -0.6428F, -17.855F, 8.7964F, 2, 1, 2, 0.0F, false));
        bone19.cubeList.add(new ModelBox(bone19, 0, 86, -1.3572F, -17.855F, 8.7964F, 1, 1, 2, 0.0F, true));

        bone20 = new RendererModel(this);
        bone20.setRotationPoint(0.0F, -12.4725F, 23.8319F);
        s686.addChild(bone20);
        setRotationAngle(bone20, -0.3491F, 0.0F, 0.0F);
        bone20.cubeList.add(new ModelBox(bone20, 0, 86, -1.999F, 1.6669F, -3.1179F, 4, 3, 7, 0.0F, false));
        bone20.cubeList.add(new ModelBox(bone20, 0, 86, -1.999F, 1.4475F, 16.6724F, 4, 3, 7, 0.0F, false));

        bone21 = new RendererModel(this);
        bone21.setRotationPoint(0.0F, -12.4725F, 23.8319F);
        s686.addChild(bone21);
        setRotationAngle(bone21, -1.2217F, 0.0F, 0.0F);
        bone21.cubeList.add(new ModelBox(bone21, 0, 86, -2.0F, -2.4993F, 6.671F, 4, 3, 5, 0.0F, false));
        bone21.cubeList.add(new ModelBox(bone21, 0, 86, -2.001F, -9.958F, 7.1035F, 4, 6, 3, 0.0F, false));

        bone24 = new RendererModel(this);
        bone24.setRotationPoint(0.0F, -15.8631F, 27.535F);
        s686.addChild(bone24);
        setRotationAngle(bone24, -1.3963F, 0.0F, 0.0F);
        bone24.cubeList.add(new ModelBox(bone24, 0, 86, -1.999F, -1.8805F, 8.8307F, 4, 3, 5, 0.0F, false));

        bone22 = new RendererModel(this);
        bone22.setRotationPoint(0.0F, -10.8044F, 29.2651F);
        s686.addChild(bone22);
        setRotationAngle(bone22, -0.7854F, 0.0F, 0.0F);
        bone22.cubeList.add(new ModelBox(bone22, 0, 86, -2.0F, 2.5324F, -0.7986F, 4, 1, 1, 0.0F, false));
        bone22.cubeList.add(new ModelBox(bone22, 0, 86, -2.0F, 5.1178F, 0.3726F, 4, 1, 1, 0.0F, false));

        bone23 = new RendererModel(this);
        bone23.setRotationPoint(0.0F, -10.8044F, 32.2651F);
        s686.addChild(bone23);
        setRotationAngle(bone23, -1.1345F, 0.0F, 0.0F);
        bone23.cubeList.add(new ModelBox(bone23, 0, 86, -2.001F, 5.0297F, -0.2124F, 4, 2, 2, 0.0F, false));

        addAnimatedParts(barrels);
    }
}
