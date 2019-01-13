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

public class ModelM416 extends ModelGun
{
	private final ModelRenderer base;
	private final ModelRenderer rail;
	private final ModelRenderer mag;
	private final ModelRenderer trigger;
	private final ModelRenderer handle;
	private final ModelRenderer stock;
	private final ModelRenderer ir;

	public ModelM416()
	{
		textureWidth = 128;
		textureHeight = 128;

		base = new ModelRenderer(this);
		base.setRotationPoint(0.0F, 24.0F, 0.0F);
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -27.0F, -35.0F, 6, 6, 26, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.0F, -25.0F, -46.0F, 2, 2, 11, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.5F, -25.5F, -51.0F, 3, 3, 5, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -27.0F, -9.0F, 6, 10, 24, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -0.5F, -28.5F, -34.0F, 1, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, 0.5F, -30.0F, -34.0F, 1, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -1.5F, -30.0F, -34.0F, 1, 2, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -17.0F, -9.0F, 6, 4, 9, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -14.0F, 0.0F, 6, 1, 8, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -17.0F, 7.0F, 6, 4, 3, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -3.0F, -15.0F, 6.0F, 6, 1, 1, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -26.0F, 15.0F, 4, 7, 28, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -19.0F, 39.0F, 4, 7, 4, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -19.0F, 32.0F, 4, 4, 9, 0.0F, false));
		base.cubeList.add(new ModelBox(base, 0, 0, -2.0F, -19.0F, 25.0F, 4, 2, 7, 0.0F, false));

		rail = new ModelRenderer(this);
		rail.setRotationPoint(0.0F, 24.0F, 0.0F);
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -27.5F, -30.5F, 5, 7, 22, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -3.5F, -26.5F, -30.5F, 7, 5, 21, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -12.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -14.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -16.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -18.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -20.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -22.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -24.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -26.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -28.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -30.0F, 5, 8, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -30.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -28.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -26.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -24.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -22.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -20.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -18.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -16.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -14.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -4.0F, -26.5F, -12.0F, 8, 5, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -10.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -27.5F, -8.5F, 5, 1, 23, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -8.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -6.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -4.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, -2.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, 0.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, 2.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, 4.0F, 5, 1, 1, 0.0F, false));
		rail.cubeList.add(new ModelBox(rail, 0, 0, -2.5F, -28.0F, 6.0F, 5, 1, 1, 0.0F, false));

		mag = new ModelRenderer(this);
		mag.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(mag, -0.1745F, 0.0F, 0.0F);
		mag.cubeList.add(new ModelBox(mag, 0, 0, -2.5F, -13.0F, -10.8F, 5, 16, 8, 0.0F, false));

		trigger = new ModelRenderer(this);
		trigger.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(trigger, -0.2618F, 0.0F, 0.0F);
		trigger.cubeList.add(new ModelBox(trigger, 0, 0, -1.0F, -18.0F, -1.0F, 2, 3, 1, 0.0F, false));

		handle = new ModelRenderer(this);
		handle.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(handle, 0.1745F, 0.0F, 0.0F);
		handle.cubeList.add(new ModelBox(handle, 0, 0, -3.0F, -15.0F, 12.0F, 6, 12, 6, 0.0F, false));

		stock = new ModelRenderer(this);
		stock.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(stock, -0.2618F, 0.0F, 0.0F);
		stock.cubeList.add(new ModelBox(stock, 0, 0, -2.0F, -25.0F, 8.0F, 4, 3, 28, 0.0F, false));

		ir = new ModelRenderer(this);
		ir.setRotationPoint(0.0F, 24.0F, 0.0F);
		ir.cubeList.add(new ModelBox(ir, 0, 0, -2.0F, -28.0F, 9.0F, 4, 1, 5, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 0, -2.0F, -29.5F, 10.0F, 1, 2, 3, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 0, 1.0F, -29.5F, 10.0F, 1, 2, 3, 0.0F, false));
		ir.cubeList.add(new ModelBox(ir, 0, 0, -0.5F, -28.5F, 11.0F, 1, 1, 1, 0.0F, false));
	}
	
	@Override
	public void render(ItemStack stack)
	{
		EntityPlayerSP player = Minecraft.getMinecraft().player;
		
		if(player != null && player.hasCapability(PlayerDataProvider.PLAYER_DATA, null))
		{
			IPlayerData data = player.getCapability(PlayerDataProvider.PLAYER_DATA, null);
			boolean aim = data.isAiming();
			
			GlStateManager.pushMatrix();
			{
				animation_held.run(player.isSprinting());
				renderM416(aim, stack);
			}
			GlStateManager.popMatrix();
		}
	}
	
	private void renderM416(boolean aim, ItemStack stack)
	{
		GlStateManager.pushMatrix();
		transform.defaultARTransform();
		
		GlStateManager.translate(0.0, 4.0, -5.0);
		
		if(aim && enableADS(stack))
		{
			rotateModelForADSRendering();
			if(hasRedDot(stack))
			{
				GlStateManager.translate(0.0, 3.7, 0.0);
			}
			
			else if(hasHoloSight(stack))
			{
				GlStateManager.translate(0.0, 5.3, 0.0);
			}
			
			GlStateManager.translate(26.55, -11, 8);
		}
		
		renderParts(hasScopeAtachment(stack));
		GlStateManager.popMatrix();
		
		renderSilencer(aim, stack);
		renderVerticalGrip(aim, stack);
		renderAngledGrip(aim, stack);
		renderRedDot(aim, stack);
		renderHolo(aim, stack);
		render2X(stack);
		render4X(stack);
	}
	
	private void renderSilencer(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack))
		{
			if(hasRedDot(stack))
			{
				renderARSilencer(-18.6, 5.9, 9, 1f, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderARSilencer(-18.6, 4.9, 9, 1f, stack);
			}
			
			else renderARSilencer(-18.6, 8.8, 9, 1f, stack);
		}
		
		else renderARSilencer(0, 0.8, 3, 1f, stack);
	}
	
	private void renderVerticalGrip(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack))
		{
			if(hasRedDot(stack))
			{
				renderVerticalGrip(19.2, -6.1, 7, 1.4f, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderVerticalGrip(19.2, -4.9, 7, 1.4f, stack);
			}
			
			else renderVerticalGrip(19.2, -9, 7, 1.4f, stack);
		}
		
		else renderVerticalGrip(-1, -2.3, 1, 1.4f, stack);
	}
	
	private void renderAngledGrip(boolean aim, ItemStack stack)
	{
		if(aim && enableADS(stack))
		{
			if(hasRedDot(stack))
			{
				renderAngledGrip(-16.3, -4.2, -7, 1.1f, stack);
			}
			
			else if(hasHoloSight(stack))
			{
				renderAngledGrip(-16.3, -3.1, -7, 1.1f, stack);
			}
			
			else renderAngledGrip(-16.3, -6.4, -7, 1.1f, stack);
		}
		
		else renderAngledGrip(0.4, 0.2, -1, 1.1f, stack);
	}
	
	private void renderRedDot(boolean aim, ItemStack stack)
	{
		if(aim)
		{
			renderRedDot(28.2, -17, 6, 1.3f, stack);
		}
		
		else renderRedDot(-0.3, -9, 0, 1.3f, stack);
	}
	
	private void renderHolo(boolean aim, ItemStack stack)
	{
		if(aim)
		{
			renderHolo(22.4, -13.9, 5, 1.3f, stack);
		}
		
		else renderHolo(-1.6, -8.9, -3, 1.3f, stack);
	}
	
	private void render2X(ItemStack stack)
	{
		renderScope2X(7.2, 6, -6, 1.1f, stack);
	}
	
	private void render4X(ItemStack stack)
	{
		renderScope4X(7, 6.7, -6, 1.1f, stack);
	}
	
	private void renderParts(boolean scope)
	{
		base.render(1f);
		rail.render(1f);
		mag.render(1f);
		trigger.render(1f);
		handle.render(1f);
		stock.render(1f);
		
		if(!scope)
		{
			ir.render(1f);
		}
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
