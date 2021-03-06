package dev.toma.pubgmc.client.model.gun;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.item.ItemStack;

public class S1897Model extends AbstractGunModel {

    private final RendererModel grip;
    private final RendererModel bone7;
    private final RendererModel bone6;
    private final RendererModel s1897;
    private final RendererModel bone2;
    private final RendererModel bone13;
    private final RendererModel bone8;
    private final RendererModel bone10;
    private final RendererModel bone9;
    private final RendererModel bone11;
    private final RendererModel bone12;
    private final RendererModel bone14;
    private final RendererModel bone15;
    private final RendererModel bone16;
    private final RendererModel bone18;
    private final RendererModel bone20;
    private final RendererModel bone21;
    private final RendererModel bone23;
    private final RendererModel bone24;
    private final RendererModel bone17;
    private final RendererModel bone19;
    private final RendererModel bone4;
    private final RendererModel bone5;
    private final RendererModel bone3;

    public S1897Model() {
        textureWidth = 512;
        textureHeight = 512;

        grip = new RendererModel(this);
        grip.setRotationPoint(1.5F, 24.0F, 0.0F);
        grip.cubeList.add(new ModelBox(grip, 145, 152, 0.3927F, -4.1927F, -40.4F, 1, 3, 10, 0.0F, true));
        grip.cubeList.add(new ModelBox(grip, 145, 152, 0.3927F, -4.1927F, -30.4F, 1, 3, 10, 0.0F, true));
        grip.cubeList.add(new ModelBox(grip, 145, 152, -4.3927F, -4.1927F, -30.4F, 1, 3, 10, 0.0F, false));
        grip.cubeList.add(new ModelBox(grip, 145, 152, -4.3927F, -4.1927F, -40.4F, 1, 3, 10, 0.0F, false));
        grip.cubeList.add(new ModelBox(grip, 145, 152, -3.0F, -0.8F, -30.4F, 3, 1, 10, 0.0F, true));
        grip.cubeList.add(new ModelBox(grip, 145, 152, -3.0F, -0.8F, -40.4F, 3, 1, 10, 0.0F, true));

        bone7 = new RendererModel(this);
        bone7.setRotationPoint(-3.0F, 0.0F, 0.0F);
        grip.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.0F, 0.6109F);
        bone7.cubeList.add(new ModelBox(bone7, 145, 152, -0.8853F, -0.8362F, -40.4F, 1, 1, 10, 0.0F, false));
        bone7.cubeList.add(new ModelBox(bone7, 145, 152, -0.8853F, -0.8362F, -30.4F, 1, 1, 10, 0.0F, false));
        bone7.cubeList.add(new ModelBox(bone7, 145, 152, 1.9142F, -3.4966F, -40.4F, 1, 1, 10, 0.0F, false));
        bone7.cubeList.add(new ModelBox(bone7, 145, 152, 1.9142F, -3.4966F, -30.4F, 1, 1, 10, 0.0F, false));

        bone6 = new RendererModel(this);
        bone6.setRotationPoint(0.0F, 0.0F, 0.0F);
        grip.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.0F, -0.6109F);
        bone6.cubeList.add(new ModelBox(bone6, 145, 152, -0.1147F, -0.8362F, -40.4F, 1, 1, 10, 0.0F, true));
        bone6.cubeList.add(new ModelBox(bone6, 145, 152, -0.1147F, -0.8362F, -30.4F, 1, 1, 10, 0.0F, true));
        bone6.cubeList.add(new ModelBox(bone6, 145, 152, -2.9142F, -3.4966F, -40.4F, 1, 1, 10, 0.0F, true));
        bone6.cubeList.add(new ModelBox(bone6, 145, 152, -2.9142F, -3.4966F, -30.4F, 1, 1, 10, 0.0F, true));

        s1897 = new RendererModel(this);
        s1897.setRotationPoint(0.0F, 24.0F, 0.0F);
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -1.0F, 1.0F, 1, 1, 9, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, 1.5F, -1.0F, 1.0F, 1, 1, 9, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -1.0F, 10.0F, 5, 1, 3, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -10.4142F, -11.0F, 5, 1, 17, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 50, 16, -1.5F, -11.0142F, -9.984F, 3, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 54, 17, -1.5F, -11.0142F, 19.016F, 3, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, -1.4329F, -12.233F, 19.5F, 1, 2, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, 0.4329F, -12.233F, 19.5F, 1, 2, 1, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, -0.5F, -11.653F, 19.5F, 1, 1, 1, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 50, 16, -1.5F, -11.0142F, -9.016F, 3, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 46, 16, -1.5F, -11.0142F, 19.984F, 3, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, -0.5F, -11.8142F, -9.8F, 1, 2, 2, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, -0.5F, -11.615F, -8.6703F, 1, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 20, 154, -0.5F, -12.5213F, -9.0929F, 1, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -10.4142F, 6.0F, 5, 1, 17, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -10.3142F, 22.2F, 5, 1, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -3.0F, 16.0F, 5, 1, 7, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, 2.2071F, -9.7071F, 6.0F, 1, 9, 7, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, 2.2071F, -9.7071F, 13.0F, 1, 7, 10, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, 2.2071F, -9.7071F, -11.0F, 1, 9, 17, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -3.2071F, -4.7071F, 0.0F, 1, 4, 13, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -3.2071F, -9.7071F, 8.0F, 1, 7, 15, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -3.2071F, -9.7071F, 0.0F, 1, 1, 8, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 4, 7, -2.8071F, -8.7071F, 0.0F, 1, 4, 8, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 4, 7, -3.0071F, -7.7071F, 0.3F, 1, 2, 2, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -3.2071F, -9.7071F, -11.0F, 1, 9, 11, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -2.5F, -10.0F, -11.0F, 5, 10, 12, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -6.5F, -33.0F, 2, 1, 22, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 142, -1.0F, -6.5F, -53.0F, 2, 1, 20, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 81, -1.5F, -9.5F, -14.6F, 3, 3, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -1.3F, -30.0F, 2, 1, 19, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -1.3F, -41.0F, 2, 1, 11, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -2.3F, -42.6F, 2, 2, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -10.2321F, -33.0F, 2, 1, 22, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 142, -1.0F, -10.2321F, -53.0F, 2, 1, 20, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -5.0321F, -30.0F, 2, 1, 19, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -5.0321F, -41.0F, 2, 1, 11, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -5.0321F, -42.6F, 2, 3, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.5F, -6.2321F, -20.3F, 3, 2, 2, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.5F, -6.2321F, -35.3F, 3, 2, 2, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, 1.366F, -8.866F, -33.0F, 1, 2, 22, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 142, 1.366F, -8.866F, -53.0F, 1, 2, 20, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, 1.366F, -3.666F, -30.0F, 1, 2, 19, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, 1.366F, -3.666F, -41.0F, 1, 2, 11, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, 0.366F, -3.666F, -42.6F, 2, 2, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.5F, -4.666F, -41.8F, 3, 4, 1, 0.0F, true));
        s1897.cubeList.add(new ModelBox(s1897, 0, 133, -2.366F, -8.866F, -33.0F, 1, 2, 22, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 142, -2.366F, -8.866F, -53.0F, 1, 2, 20, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -2.366F, -3.666F, -30.0F, 1, 2, 19, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -2.366F, -3.666F, -41.0F, 1, 2, 11, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -2.366F, -3.666F, -42.6F, 2, 2, 1, 0.0F, false));
        s1897.cubeList.add(new ModelBox(s1897, 0, 146, -1.0F, -3.666F, -42.9F, 2, 2, 1, 0.0F, false));

        bone2 = new RendererModel(this);
        bone2.setRotationPoint(-0.5F, 0.2F, 0.1F);
        s1897.addChild(bone2);
        setRotationAngle(bone2, -0.0349F, 0.0F, 0.0F);
        bone2.cubeList.add(new ModelBox(bone2, 0, 81, -1.0F, -1.7698F, -0.0012F, 3, 1, 10, 0.0F, false));

        bone13 = new RendererModel(this);
        bone13.setRotationPoint(0.5F, 6.7F, 0.0F);
        s1897.addChild(bone13);
        setRotationAngle(bone13, 0.5236F, 0.0F, 0.0F);
        bone13.cubeList.add(new ModelBox(bone13, 0, 81, -3.0F, -0.3024F, 14.6083F, 5, 1, 6, 0.0F, true));
        bone13.cubeList.add(new ModelBox(bone13, 0, 81, -3.5F, -3.9086F, 14.9583F, 6, 4, 6, 0.0F, true));

        bone8 = new RendererModel(this);
        bone8.setRotationPoint(0.3F, -11.5142F, -9.0F);
        s1897.addChild(bone8);
        setRotationAngle(bone8, 0.0F, 0.0F, 0.3491F);
        bone8.cubeList.add(new ModelBox(bone8, 48, 13, 0.7744F, -0.5999F, -1.0F, 1, 2, 2, 0.0F, true));
        bone8.cubeList.add(new ModelBox(bone8, 48, 13, 0.7744F, -0.5999F, 28.0F, 1, 2, 2, 0.0F, true));

        bone10 = new RendererModel(this);
        bone10.setRotationPoint(-0.3F, -11.5142F, -9.0F);
        s1897.addChild(bone10);
        setRotationAngle(bone10, 0.0F, 0.0F, -0.3491F);
        bone10.cubeList.add(new ModelBox(bone10, 48, 13, -1.7744F, -0.5999F, -1.0F, 1, 2, 2, 0.0F, false));
        bone10.cubeList.add(new ModelBox(bone10, 48, 13, -1.7744F, -0.5999F, 28.0F, 1, 2, 2, 0.0F, false));

        bone9 = new RendererModel(this);
        bone9.setRotationPoint(-0.3F, -11.5142F, -9.0F);
        s1897.addChild(bone9);
        setRotationAngle(bone9, 0.0F, 0.0F, -0.3491F);


        bone11 = new RendererModel(this);
        bone11.setRotationPoint(0.0F, -12.3142F, -8.3F);
        s1897.addChild(bone11);
        setRotationAngle(bone11, 0.7854F, 0.0F, 0.0F);
        bone11.cubeList.add(new ModelBox(bone11, 20, 154, -0.5F, -0.7071F, -1.4142F, 1, 1, 1, 0.0F, true));
        bone11.cubeList.add(new ModelBox(bone11, 20, 154, -0.5F, 0.6468F, -1.7562F, 1, 1, 1, 0.0F, true));

        bone12 = new RendererModel(this);
        bone12.setRotationPoint(0.0F, -12.3142F, -8.3F);
        s1897.addChild(bone12);
        setRotationAngle(bone12, 0.4363F, 0.0F, 0.0F);
        bone12.cubeList.add(new ModelBox(bone12, 20, 154, -0.5F, -0.1002F, -0.7248F, 1, 1, 1, 0.0F, true));

        bone14 = new RendererModel(this);
        bone14.setRotationPoint(0.5F, 0.0F, 0.0F);
        s1897.addChild(bone14);
        setRotationAngle(bone14, -0.2618F, 0.0F, 0.0F);
        bone14.cubeList.add(new ModelBox(bone14, 0, 81, -3.7071F, -15.3292F, 19.7039F, 1, 7, 7, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 0, 81, -3.0F, -16.0363F, 19.7039F, 5, 1, 7, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, -2.0F, -16.7383F, 21.6193F, 3, 1, 5, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, -2.0F, -17.0194F, 20.1775F, 3, 2, 2, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, 0.5F, -16.8194F, 20.6775F, 1, 1, 2, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, -2.5F, -16.8194F, 20.3775F, 1, 1, 2, 0.0F, false));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, -1.5F, -17.0194F, 22.1775F, 2, 1, 2, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 97, 149, -1.0F, -17.0194F, 24.1775F, 1, 1, 2, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 0, 81, -3.0F, -8.6221F, 19.7039F, 5, 1, 7, 0.0F, true));
        bone14.cubeList.add(new ModelBox(bone14, 0, 81, 1.7071F, -15.3292F, 19.7039F, 1, 7, 7, 0.0F, true));

        bone15 = new RendererModel(this);
        bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone14.addChild(bone15);
        setRotationAngle(bone15, 0.0F, 0.0F, -0.7854F);
        bone15.cubeList.add(new ModelBox(bone15, 0, 81, 8.218F, -13.4607F, 19.7039F, 1, 1, 7, 0.0F, true));
        bone15.cubeList.add(new ModelBox(bone15, 0, 81, 11.7536F, -9.9252F, 19.7039F, 1, 1, 7, 0.0F, true));

        bone16 = new RendererModel(this);
        bone16.setRotationPoint(0.0F, 7.0F, 0.0F);
        bone14.addChild(bone16);
        setRotationAngle(bone16, 0.0F, 0.0F, -0.7854F);
        bone16.cubeList.add(new ModelBox(bone16, 0, 81, 8.218F, -13.4607F, 19.7039F, 1, 1, 7, 0.0F, true));
        bone16.cubeList.add(new ModelBox(bone16, 0, 81, 11.7536F, -9.9252F, 19.7039F, 1, 1, 7, 0.0F, true));

        bone18 = new RendererModel(this);
        bone18.setRotationPoint(0.5F, 0.0F, 16.0F);
        s1897.addChild(bone18);
        setRotationAngle(bone18, -0.5236F, 0.0F, 0.0F);
        bone18.cubeList.add(new ModelBox(bone18, 0, 81, -3.7071F, -13.7183F, 7.9701F, 1, 7, 8, 0.0F, true));
        bone18.cubeList.add(new ModelBox(bone18, 0, 81, -3.0F, -14.4254F, 7.9701F, 5, 1, 8, 0.0F, true));
        bone18.cubeList.add(new ModelBox(bone18, 0, 81, -3.0F, -7.0112F, 7.9701F, 5, 1, 8, 0.0F, true));
        bone18.cubeList.add(new ModelBox(bone18, 0, 81, 1.7071F, -13.7183F, 7.9701F, 1, 7, 8, 0.0F, true));

        bone20 = new RendererModel(this);
        bone20.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone18.addChild(bone20);
        setRotationAngle(bone20, 0.0F, 0.0F, -0.7854F);
        bone20.cubeList.add(new ModelBox(bone20, 0, 81, 7.079F, -12.3216F, 7.9701F, 1, 1, 8, 0.0F, true));
        bone20.cubeList.add(new ModelBox(bone20, 0, 81, 10.6145F, -8.7861F, 7.9701F, 1, 1, 8, 0.0F, true));

        bone21 = new RendererModel(this);
        bone21.setRotationPoint(0.0F, 7.0F, 0.0F);
        bone18.addChild(bone21);
        setRotationAngle(bone21, 0.0F, 0.0F, -0.7854F);
        bone21.cubeList.add(new ModelBox(bone21, 0, 81, 7.079F, -12.3216F, 7.9701F, 1, 1, 8, 0.0F, true));
        bone21.cubeList.add(new ModelBox(bone21, 0, 81, 10.6145F, -8.7861F, 7.9701F, 1, 1, 8, 0.0F, true));

        bone23 = new RendererModel(this);
        bone23.setRotationPoint(0.5F, 7.5F, 10.2F);
        s1897.addChild(bone23);
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, -3.7071F, -12.8821F, 22.6764F, 1, 5, 20, 0.0F, true));
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, -3.7071F, -7.8821F, 39.6764F, 1, 4, 3, 0.0F, true));
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, -3.0F, -13.5892F, 22.6764F, 5, 1, 20, 0.0F, true));
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, -3.0F, -12.6892F, 40.6964F, 5, 9, 2, 0.0F, true));
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, 1.7071F, -12.8821F, 22.6764F, 1, 5, 20, 0.0F, true));
        bone23.cubeList.add(new ModelBox(bone23, 0, 81, 1.7071F, -7.8821F, 39.6764F, 1, 4, 3, 0.0F, true));

        bone24 = new RendererModel(this);
        bone24.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone23.addChild(bone24);
        setRotationAngle(bone24, 0.0F, 0.0F, -0.7854F);
        bone24.cubeList.add(new ModelBox(bone24, 0, 81, 6.4877F, -11.7303F, 22.6764F, 1, 1, 20, 0.0F, true));
        bone24.cubeList.add(new ModelBox(bone24, 0, 81, 10.0232F, -8.1948F, 22.6764F, 1, 1, 20, 0.0F, true));

        bone17 = new RendererModel(this);
        bone17.setRotationPoint(0.5F, -1.3F, -11.9F);
        s1897.addChild(bone17);
        setRotationAngle(bone17, -0.0873F, 0.0F, 0.0F);
        bone17.cubeList.add(new ModelBox(bone17, 0, 81, -3.7071F, -5.0396F, 44.8886F, 1, 4, 19, 0.0F, true));
        bone17.cubeList.add(new ModelBox(bone17, 0, 81, -3.0F, -1.3324F, 44.8886F, 5, 1, 19, 0.0F, true));
        bone17.cubeList.add(new ModelBox(bone17, 0, 81, 1.7071F, -5.0396F, 44.8886F, 1, 4, 19, 0.0F, true));

        bone19 = new RendererModel(this);
        bone19.setRotationPoint(0.0F, 7.0F, 0.0F);
        bone17.addChild(bone19);
        setRotationAngle(bone19, 0.0F, 0.0F, -0.7854F);
        bone19.cubeList.add(new ModelBox(bone19, 0, 81, 3.0635F, -8.3061F, 44.8886F, 1, 1, 19, 0.0F, true));
        bone19.cubeList.add(new ModelBox(bone19, 0, 81, 6.599F, -4.7706F, 44.8886F, 1, 1, 19, 0.0F, true));

        bone4 = new RendererModel(this);
        bone4.setRotationPoint(1.0F, 0.0F, 0.0F);
        s1897.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, 0.5236F);
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -5.4821F, -4.7631F, -33.0F, 1, 1, 22, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -5.4821F, -4.7631F, -53.0F, 1, 1, 20, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.8821F, -0.2598F, -30.0F, 1, 1, 19, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.8821F, -0.2598F, -41.0F, 1, 1, 11, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.8821F, -0.2598F, -42.6F, 1, 1, 1, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -3.25F, -6.6292F, -33.0F, 1, 1, 22, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -3.25F, -6.6292F, -53.0F, 1, 1, 20, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -0.65F, -2.1258F, -30.0F, 1, 1, 19, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -0.65F, -2.1258F, -41.0F, 1, 1, 11, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -1.65F, -2.1258F, -42.6F, 2, 1, 1, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -7.3481F, -6.9952F, -33.0F, 1, 1, 22, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -7.3481F, -6.9952F, -53.0F, 1, 1, 20, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -4.7481F, -2.4919F, -30.0F, 1, 1, 19, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -4.7481F, -2.4919F, -41.0F, 1, 1, 11, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -4.7481F, -2.4919F, -42.6F, 2, 1, 1, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -5.116F, -8.8612F, -33.0F, 1, 1, 22, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -5.116F, -8.8612F, -53.0F, 1, 1, 20, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.516F, -4.3579F, -30.0F, 1, 1, 19, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.516F, -4.3579F, -41.0F, 1, 1, 11, 0.0F, true));
        bone4.cubeList.add(new ModelBox(bone4, 0, 142, -2.516F, -4.3579F, -42.6F, 1, 1, 1, 0.0F, true));

        bone5 = new RendererModel(this);
        bone5.setRotationPoint(-1.0F, 0.0F, 0.0F);
        s1897.addChild(bone5);
        setRotationAngle(bone5, 0.0F, 0.0F, -0.5236F);
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 4.4821F, -4.7631F, -33.0F, 1, 1, 22, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 4.4821F, -4.7631F, -53.0F, 1, 1, 20, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.8821F, -0.2598F, -30.0F, 1, 1, 19, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.8821F, -0.2598F, -41.0F, 1, 1, 11, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.8821F, -0.2598F, -42.6F, 1, 1, 1, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 2.25F, -6.6292F, -33.0F, 1, 1, 22, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 2.25F, -6.6292F, -53.0F, 1, 1, 20, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, -0.35F, -2.1258F, -30.0F, 1, 1, 19, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, -0.35F, -2.1258F, -41.0F, 1, 1, 11, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, -0.35F, -2.1258F, -42.6F, 2, 1, 1, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 6.3481F, -6.9952F, -33.0F, 1, 1, 22, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 6.3481F, -6.9952F, -53.0F, 1, 1, 20, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 3.7481F, -2.4919F, -30.0F, 1, 1, 19, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 3.7481F, -2.4919F, -41.0F, 1, 1, 11, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 2.7481F, -2.4919F, -42.6F, 2, 1, 1, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 4.116F, -8.8612F, -33.0F, 1, 1, 22, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 4.116F, -8.8612F, -53.0F, 1, 1, 20, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.516F, -4.3579F, -30.0F, 1, 1, 19, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.516F, -4.3579F, -41.0F, 1, 1, 11, 0.0F, false));
        bone5.cubeList.add(new ModelBox(bone5, 0, 142, 1.516F, -4.3579F, -42.6F, 1, 1, 1, 0.0F, false));

        bone3 = new RendererModel(this);
        bone3.setRotationPoint(0.5F, 0.0F, 0.0F);
        s1897.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 0.0F, 0.7854F);
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -3.1213F, 1.1213F, -11.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, 0.4142F, -2.4142F, -11.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -5.9497F, -8.7782F, -11.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -5.9497F, -8.7782F, 6.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -1.0F, -3.8284F, 13.0F, 1, 1, 10, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -9.4853F, -5.2426F, -11.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -9.4853F, -5.2426F, 6.0F, 1, 1, 17, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -4.5355F, -0.2929F, 13.0F, 1, 1, 10, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, -3.1213F, 1.1213F, 6.0F, 1, 1, 7, 0.0F, true));
        bone3.cubeList.add(new ModelBox(bone3, 0, 81, 0.4142F, -2.4142F, 6.0F, 1, 1, 7, 0.0F, true));

        addAnimatedParts(grip);
    }

    @Override
    public void doModelRender(ItemStack stack) {
        s1897.render(1.0F);
    }
}
