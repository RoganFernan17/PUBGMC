package com.toma.pubgmc.client.models.weapons;

import com.toma.pubgmc.client.models.ModelGun;
import com.toma.pubgmc.common.capability.IPlayerData;
import com.toma.pubgmc.common.capability.IPlayerData.PlayerDataProvider;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;

public class ModelVector extends ModelGun
{
	private final ModelRenderer base;
	private final ModelRenderer rail;
	private final ModelRenderer angle;
	private final ModelRenderer angle2;

	public ModelVector() 
	{
		textureWidth = 128;
		textureHeight = 128;

		base = new ModelRenderer(this);
		base.setRotationPoint(0.0F, 24.0F, 0.0F);
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -29.0F, -23.0F, 6, 3, 24, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 64, -3.0F, -26.0F, -23.0F, 6, 3, 13, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.0F, -27.0F, -24.0F, 2, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -0.5F, -30.5F, -22.0F, 1, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -29.0F, 1.0F, 6, 3, 7, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 64, -3.0F, -26.0F, -10.0F, 6, 3, 4, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 64, -3.0F, -19.0F, -10.0F, 6, 3, 8, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -18.0F, -2.0F, 6, 2, 14, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -28.0F, 7.7F, 6, 2, 13, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -25.0F, 20.7F, 6, 2, 10, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -18.8F, 22.7F, 6, 2, 8, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -25.8F, 27.7F, 6, 10, 4, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -26.8F, 1.7F, 4, 3, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -23.8F, 2.7F, 4, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -22.8F, 3.7F, 4, 1, 4, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -16.5F, -9.0F, 4, 1, 6, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -0.5F, -29.5F, 4.0F, 1, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -29.5F, 4.0F, 1, 1, 3, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, 2.0F, -29.5F, 4.0F, 1, 1, 3, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.5F, -30.5F, 4.0F, 1, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, 0.5F, -30.5F, 4.0F, 1, 2, 1, 0.0F, false));

		rail = new ModelRenderer(this);
		rail.setRotationPoint(0.0F, 24.0F, 0.0F);
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -19.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -17.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -15.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -13.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -11.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -9.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -7.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -5.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -3.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, -1.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -29.3F, 1.0F, 5, 1, 1, 0.0F, false));

		angle = new ModelRenderer(this);
		angle.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(angle, 0.3491F, 0.0F, 0.0F);
		angle.cubeList.add(new ModelBox(angle, 0, 0, -3.0F, -27.0F, 4.0F, 6, 11, 4, 0.0F, false));
		angle.cubeList.add(new ModelBox(angle, 0, 64, -3.0F, -26.5F, -4.0F, 6, 8, 8, 0.0F, false));
		angle.cubeList.add(new ModelBox(angle, 0, 0, -3.0F, -24.0F, 14.0F, 6, 12, 3, 0.0F, false));
		angle.cubeList.add(new ModelBox(angle, 0, 0, -3.0F, -19.0F, 27.0F, 6, 11, 2, 0.0F, false));

		angle2 = new ModelRenderer(this);
		angle2.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(angle2, -0.0873F, 0.0F, 0.0F);
		angle2.cubeList.add(new ModelBox(angle2, 0, 0, -1.0F, -27.6F, 2.0F, 1, 3, 1, 0.0F, false));
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
	
	@Override
	public void render(ItemStack stack)
	{
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		
		if(player != null && player.hasCapability(PlayerDataProvider.PLAYER_DATA, null))
		{
			IPlayerData data = player.getCapability(PlayerDataProvider.PLAYER_DATA, null);
			boolean aiming = data.isAiming();
			
			renderVector(aiming, stack);
			
			if(hasVerticalGrip(stack))
			{
				renderGrip(aiming, stack);
			}
			
			if(hasSilencer(stack))
			{
				renderSilencer(aiming, stack);
			}
			
			if(hasRedDot(stack))
			{
				renderRedDotSight(aiming, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderHolo(aiming, stack);
			}
			
			else if(has2X(stack))
			{
				render2X(stack);
			}
			
			else if(has4X(stack))
			{
				render4X(stack);
			}
		}
	}
	
	private void renderVector(boolean aim, ItemStack stack)
	{
		GlStateManager.pushMatrix();
		transform.defaultSMGTransform();
		GlStateManager.translate(0.0, 11.0, 0.0);
		
		if(aim && enableADS(stack))
		{
			rotateModelForADSRendering();
			GlStateManager.translate(18.6, -10.2, 7.0);
			
			if(hasRedDot(stack))
			{
				GlStateManager.translate(0.0, 2.9, 0.0);
			}
			
			else if(hasHoloSight(stack))
			{
				GlStateManager.translate(0.0, 2.9, 0.0);
			}
		}
		renderParts();
		GlStateManager.popMatrix();
	}
	
	private void renderSilencer(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack))
		{
			if(hasRedDot(stack))
			{
				renderSMGSilencer(-16.79, 2.1, -4.8, 1.1f, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderSMGSilencer(-16.79, 2, -4.8, 1.1f, stack);
			}
			
			else renderSMGSilencer(-16.79, 5, -4.8, 1.1f, stack);
		}
		
		else renderSMGSilencer(0, -4.2, -11, 1.1f, stack);
	}
	
	private void renderGrip(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack))
		{
			if(hasRedDot(stack))
			{
				renderVerticalGrip(27, -3.1, 11, 1f, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderVerticalGrip(27, -3, 11, 1f, stack);
			}
			
			else renderVerticalGrip(27, -7, 11, 1f, stack);
		}
		
		else renderVerticalGrip(-1, 9, 0, 1f, stack);
	}
	
	private void renderRedDotSight(boolean aim, ItemStack stack)
	{
		if(aim)
		{
			renderRedDot(23, -17.3, 10, 1.6f, stack);
		}
		
		else renderRedDot(-0.4, -8, -0.8, 1.6f, stack);
	}
	
	private void renderHolo(boolean aim, ItemStack stack)
	{
		if(aim)
		{
			renderHolo(22.4, -13.8, 5.0, 1.3f, stack);
		}
		
		else renderHolo(-1.5, -5, -3, 1.3f, stack);
	}
	
	private void render2X(ItemStack stack)
	{
		renderScope2X(8, 13, -7, 1f, stack);
	}
	
	private void render4X(ItemStack stack)
	{
		renderScope4X(7.79, 13, -5, 1f, stack);
	}
	
	private void renderParts()
	{
		base.render(1f);
		rail.render(1f);
		angle.render(1f);
		angle2.render(1f);
	}
}