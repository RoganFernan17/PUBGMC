package dev.toma.pubgmc.client.model.entity;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelBox;

public class ParachuteModel extends Model {

    private final RendererModel main;
    private final RendererModel cloth;
    private final RendererModel left;
    private final RendererModel right;
    private final RendererModel front;
    private final RendererModel fRight;
    private final RendererModel fLeft;
    private final RendererModel back;
    private final RendererModel bLeft;
    private final RendererModel bRight;
    private final RendererModel rope;
    private final RendererModel fr;
    private final RendererModel fl;
    private final RendererModel br;
    private final RendererModel bl;
    private final RendererModel fr1;
    private final RendererModel br1;
    private final RendererModel handle;
    private final RendererModel hfr;
    private final RendererModel hbr;

    public ParachuteModel() {
        textureWidth = 128;
        textureHeight = 128;

        main = new RendererModel(this);
        main.setRotationPoint(0.0F, 0.0F, 0.0F);

        cloth = new RendererModel(this);
        cloth.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(cloth);
        cloth.cubeList.add(new ModelBox(cloth, 0, 55, -12.0F, -32.0F, -5.0F, 24, 1, 10, 0.0F, false));

        left = new RendererModel(this);
        left.setRotationPoint(33.0F, 5.0F, -5.0F);
        setRotationAngle(left, 0.0F, 0.0F, 0.2618F);
        cloth.addChild(left);
        left.cubeList.add(new ModelBox(left, 0, 44, -30.0F, -30.3154F, 0.0F, 24, 1, 10, 0.0F, false));

        right = new RendererModel(this);
        right.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(right, 0.0F, 0.0F, -0.2618F);
        cloth.addChild(right);
        right.cubeList.add(new ModelBox(right, 58, 12, -27.0F, -34.0281F, -5.0F, 23, 1, 10, 0.0F, false));

        front = new RendererModel(this);
        front.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(front, 0.0873F, 0.0F, 0.0F);
        cloth.addChild(front);
        front.cubeList.add(new ModelBox(front, 0, 33, -12.0F, -32.3112F, -11.9995F, 24, 1, 10, 0.0F, false));

        fRight = new RendererModel(this);
        fRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(fRight, 0.0F, 0.0F, -0.2618F);
        front.addChild(fRight);
        fRight.cubeList.add(new ModelBox(fRight, 58, 1, -26.9194F, -34.3287F, -11.9995F, 23, 1, 10, 0.0F, false));

        fLeft = new RendererModel(this);
        fLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(fLeft, 0.0F, 0.0F, 0.2618F);
        front.addChild(fLeft);
        fLeft.cubeList.add(new ModelBox(fLeft, 0, 22, 3.1349F, -34.2828F, -11.9735F, 24, 1, 10, 0.0F, false));

        back = new RendererModel(this);
        back.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(back, -0.0873F, 0.0F, 0.0F);
        cloth.addChild(back);
        back.cubeList.add(new ModelBox(back, 0, 11, -12.0F, -32.3199F, 2.0991F, 24, 1, 10, 0.0F, false));

        bLeft = new RendererModel(this);
        bLeft.setRotationPoint(2.0F, -9.663F, 7.1852F);
        setRotationAngle(bLeft, 0.0F, 0.0F, 0.2618F);
        back.addChild(bLeft);
        bLeft.cubeList.add(new ModelBox(bLeft, 0, 0, 3.6465F, -24.4483F, -5.0125F, 24, 1, 10, 0.0F, false));

        bRight = new RendererModel(this);
        bRight.setRotationPoint(0.0F, -0.3199F, 7.0991F);
        setRotationAngle(bRight, 0.0F, 0.0F, -0.2618F);
        back.addChild(bRight);
        bRight.cubeList.add(new ModelBox(bRight, 58, 58, -27.0F, -34.0281F, -5.0F, 23, 1, 10, 0.0F, false));

        rope = new RendererModel(this);
        rope.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(rope);
        rope.cubeList.add(new ModelBox(rope, 13, 40, -8.0F, 2.0F, -3.0F, 16, 1, 6, 0.0F, false));

        fr = new RendererModel(this);
        fr.setRotationPoint(-12.0F, -25.0F, -9.0F);
        setRotationAngle(fr, -0.2618F, 0.0F, 0.6981F);
        rope.addChild(fr);
        fr.cubeList.add(new ModelBox(fr, 7, 89, 31.963F, -32.5918F, 12.1094F, 1, 38, 1, 0.0F, false));

        fl = new RendererModel(this);
        fl.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(fl, -0.2618F, 0.0F, -0.6981F);
        rope.addChild(fl);
        fl.cubeList.add(new ModelBox(fl, 7, 89, -7.5146F, -40.9796F, 0.3137F, 1, 38, 1, 0.0F, false));

        br = new RendererModel(this);
        br.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(br, 0.2618F, 0.0F, 0.6981F);
        rope.addChild(br);
        br.cubeList.add(new ModelBox(br, 7, 89, 6.7167F, -41.4853F, -1.4134F, 1, 38, 1, 0.0F, false));

        bl = new RendererModel(this);
        bl.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(bl, 0.2618F, 0.0F, -0.6981F);
        rope.addChild(bl);
        bl.cubeList.add(new ModelBox(bl, 7, 89, -7.5988F, -41.2354F, -1.4803F, 1, 38, 1, 0.0F, false));

        fr1 = new RendererModel(this);
        fr1.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(fr1, -0.3491F, 0.0F, 0.0F);
        rope.addChild(fr1);
        fr1.cubeList.add(new ModelBox(fr1, 7, 89, 6.963F, -32.5983F, 1.9002F, 1, 34, 1, 0.0F, false));
        fr1.cubeList.add(new ModelBox(fr1, 7, 89, -7.537F, -32.5983F, 1.9002F, 1, 34, 1, 0.0F, false));

        br1 = new RendererModel(this);
        br1.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(br1, 0.3491F, 0.0F, 0.0F);
        rope.addChild(br1);
        br1.cubeList.add(new ModelBox(br1, 7, 89, -7.537F, -32.7023F, -3.0636F, 1, 34, 1, 0.0F, false));
        br1.cubeList.add(new ModelBox(br1, 7, 89, 6.763F, -32.6339F, -2.8757F, 1, 34, 1, 0.0F, false));

        handle = new RendererModel(this);
        handle.setRotationPoint(0.0F, 0.0F, 0.0F);
        main.addChild(handle);

        hfr = new RendererModel(this);
        hfr.setRotationPoint(0.0F, 0.0F, 0.0F);
        setRotationAngle(hfr, -0.1745F, 0.0F, 0.0F);
        handle.addChild(hfr);
        hfr.cubeList.add(new ModelBox(hfr, 9, 92, 6.8F, 2.2886F, 2.1123F, 1, 12, 1, 0.0F, false));
        hfr.cubeList.add(new ModelBox(hfr, 9, 92, -7.8F, 2.3871F, 2.1296F, 1, 12, 1, 0.0F, false));

        hbr = new RendererModel(this);
        hbr.setRotationPoint(0.0F, 1.0F, -5.0F);
        setRotationAngle(hbr, 0.1745F, 0.0F, 0.0F);
        handle.addChild(hbr);
        hbr.cubeList.add(new ModelBox(hbr, 9, 92, 6.8F, 1.9864F, 2.1121F, 1, 12, 1, 0.0F, false));
        hbr.cubeList.add(new ModelBox(hbr, 9, 92, -7.8F, 2.1833F, 2.0774F, 1, 12, 1, 0.0F, false));
    }

    public void renderChute() {
        main.render(1.0F);
    }

    public void setRotationAngle(RendererModel model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
