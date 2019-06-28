package com.toma.pubgmc.client.renderer;

import com.toma.pubgmc.Pubgmc;
import com.toma.pubgmc.client.models.ModelGun;
import com.toma.pubgmc.client.models.weapons.ModelAKM;
import com.toma.pubgmc.client.models.weapons.ModelAUG;
import com.toma.pubgmc.client.models.weapons.ModelAWM;
import com.toma.pubgmc.client.models.weapons.ModelBerylM762;
import com.toma.pubgmc.client.models.weapons.ModelDP28;
import com.toma.pubgmc.client.models.weapons.ModelDeagle;
import com.toma.pubgmc.client.models.weapons.ModelFlareGun;
import com.toma.pubgmc.client.models.weapons.ModelG36C;
import com.toma.pubgmc.client.models.weapons.ModelGroza;
import com.toma.pubgmc.client.models.weapons.ModelKar98K;
import com.toma.pubgmc.client.models.weapons.ModelM16A4;
import com.toma.pubgmc.client.models.weapons.ModelM24;
import com.toma.pubgmc.client.models.weapons.ModelM249;
import com.toma.pubgmc.client.models.weapons.ModelM416;
import com.toma.pubgmc.client.models.weapons.ModelMK14;
import com.toma.pubgmc.client.models.weapons.ModelMK47Mutant;
import com.toma.pubgmc.client.models.weapons.ModelMP5K;
import com.toma.pubgmc.client.models.weapons.ModelMicroUzi;
import com.toma.pubgmc.client.models.weapons.ModelMini14;
import com.toma.pubgmc.client.models.weapons.ModelP18C;
import com.toma.pubgmc.client.models.weapons.ModelP1911;
import com.toma.pubgmc.client.models.weapons.ModelP92;
import com.toma.pubgmc.client.models.weapons.ModelPP19Bizon;
import com.toma.pubgmc.client.models.weapons.ModelQBU;
import com.toma.pubgmc.client.models.weapons.ModelQBZ;
import com.toma.pubgmc.client.models.weapons.ModelR1895;
import com.toma.pubgmc.client.models.weapons.ModelR45;
import com.toma.pubgmc.client.models.weapons.ModelS12K;
import com.toma.pubgmc.client.models.weapons.ModelS1897;
import com.toma.pubgmc.client.models.weapons.ModelS686;
import com.toma.pubgmc.client.models.weapons.ModelSKS;
import com.toma.pubgmc.client.models.weapons.ModelSLR;
import com.toma.pubgmc.client.models.weapons.ModelSawedOff;
import com.toma.pubgmc.client.models.weapons.ModelScarL;
import com.toma.pubgmc.client.models.weapons.ModelScorpion;
import com.toma.pubgmc.client.models.weapons.ModelTommyGun;
import com.toma.pubgmc.client.models.weapons.ModelUmp45;
import com.toma.pubgmc.client.models.weapons.ModelVSS;
import com.toma.pubgmc.client.models.weapons.ModelVector;
import com.toma.pubgmc.client.models.weapons.ModelWin94;
import com.toma.pubgmc.common.items.guns.GunBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class WeaponTEISR extends TileEntityItemStackRenderer
{
	//model
	public final ModelFlareGun flareGun = new ModelFlareGun();
	public final ModelP92 p92 = new ModelP92();
	public final ModelP1911 p1911 = new ModelP1911();
	public final ModelP18C p18c = new ModelP18C();
	public final ModelR45 r45 = new ModelR45();
	public final ModelR1895 r1895 = new ModelR1895();
	public final ModelScorpion scorpion = new ModelScorpion();
	public final ModelDeagle deagle = new ModelDeagle();
	public final ModelWin94 win94 = new ModelWin94();
	public final ModelSawedOff sawedOff = new ModelSawedOff();
	public final ModelS1897 s1897 = new ModelS1897();
	public final ModelS686 s686 = new ModelS686();
	public final ModelS12K s12k = new ModelS12K();
	public final ModelMicroUzi microuzi = new ModelMicroUzi();
	public final ModelUmp45 ump = new ModelUmp45();
	public final ModelTommyGun tommygun = new ModelTommyGun();
	public final ModelPP19Bizon bizon = new ModelPP19Bizon();
	public final ModelMP5K mp5k = new ModelMP5K();
	public final ModelVector vector = new ModelVector();
	public final ModelM16A4 m16a4 = new ModelM16A4();
	public final ModelM416 m416 = new ModelM416();
	public final ModelScarL scar = new ModelScarL();
	public final ModelG36C g36c = new ModelG36C();
	public final ModelQBZ qbz = new ModelQBZ();
	public final ModelAUG aug = new ModelAUG();
	public final ModelAKM akm = new ModelAKM();
	public final ModelBerylM762 m762 = new ModelBerylM762();
	public final ModelMK47Mutant mk47 = new ModelMK47Mutant();
	public final ModelGroza groza = new ModelGroza();
	public final ModelDP28 dp28 = new ModelDP28();
	public final ModelM249 m249 = new ModelM249();
	public final ModelVSS vss = new ModelVSS();
	public final ModelMini14 mini14 = new ModelMini14();
	public final ModelQBU qbu = new ModelQBU();
	public final ModelSKS sks = new ModelSKS();
	public final ModelSLR slr = new ModelSLR();
	public final ModelMK14 mk14 = new ModelMK14();
	public final ModelKar98K kar98k = new ModelKar98K();
	public final ModelM24 m24 = new ModelM24();
	public final ModelAWM awm = new ModelAWM();
	
	
	@Override
	public void renderByItem(ItemStack stack)
	{
		GunBase.GUNS.stream().filter(g -> g == stack.getItem()).forEach(g -> {
			ModelGun gun = g.getWeaponModel();
			bindTexture(gun.textureName());
			gun.render(stack);
		});
	}
	
	private void bindTexture(String name)
	{
		ResourceLocation rl = new ResourceLocation(Pubgmc.MOD_ID + ":textures/weapons/" + name + ".png");
		Minecraft.getMinecraft().getTextureManager().bindTexture(rl);
	}
}
