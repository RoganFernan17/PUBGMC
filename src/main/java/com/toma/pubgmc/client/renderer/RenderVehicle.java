package com.toma.pubgmc.client.renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.toma.pubgmc.Pubgmc;
import com.toma.pubgmc.client.models.vehicles.ModelVehicle;
import com.toma.pubgmc.common.entity.EntityVehicle;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public abstract class RenderVehicle<V extends EntityVehicle> extends Render<V>
{
	protected static final Random RNG = new Random();
	private ModelVehicle vehicleModel;
	private float scaling[] = new float[] {1f, 1f, 1f};
	private double translation[] = new double[] {0d, 0d, 0d};
	protected final List<ResourceLocation> textures = new ArrayList<ResourceLocation>();
	private ResourceLocation currentTexture;
	
	public RenderVehicle(RenderManager manager) 
	{
		super(manager);
		initializeModelRendering(getVehicleModel());
	}
	
	public abstract ModelVehicle getVehicleModel();
	
	public void scaleModel(float scale)
	{
		for(int i = 0; i < scaling.length; i++)
		{
			scaling[i] = scale;
		}
	}
	
	public void scaleModel(float x, float y, float z)
	{
		scaling[0] = x;
		scaling[1] = y;
		scaling[2] = z;
	}
	
	public void translateModel(double x, double y, double z)
	{
		translation[0] = x;
		translation[1] = y;
		translation[2] = z;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(V entity) 
	{
		if(currentTexture == null) initTexture();
		return currentTexture;
	}
	
	@Override
	public void doRender(V entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		if(!isModelReady()) initializeModelRendering(getVehicleModel());
		if(textures.isEmpty()) initTextures(entity);
		
		GlStateManager.pushMatrix();
		{
			bindEntityTexture(entity);
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(180, 1, 0, 0);
			GlStateManager.scale(scaling[0], scaling[1], scaling[2]);
			GlStateManager.translate(translation[0], translation[1], translation[2]);
			GlStateManager.rotate(entity.rotationYaw, 0f, 1f, 0f);
			this.getVehicleModel().render(entity.turnModifier);
		}
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	
	protected ResourceLocation defaultTexture()
	{
		return new ResourceLocation("");
	}
	
	private boolean isModelReady()
	{
		return vehicleModel != null;
	}
	
	private void initializeModelRendering(ModelVehicle modelToRender)
	{
		vehicleModel = modelToRender;
	}
	
	private void initTexture() throws IllegalArgumentException
	{
		if(textures.isEmpty()) throw new IllegalArgumentException("Texture set is empty!");
		
		currentTexture = textures.get(RNG.nextInt(textures.size()));
	}
	
	private void initTextures(V entity)
	{
		textures.clear();
		final String prefix = Pubgmc.MOD_ID + ":textures/vehicle/";
		if(entity.getTextureVariants() != null)
		{
			for(int i = 0; i < entity.getTextureVariants().length; i++)
			{
				tryToAdd(new ResourceLocation(prefix + entity.getTextureVariants()[i] + ".png"));
			}
		}
		
		else tryToAdd(defaultTexture());
	}
	
	private void tryToAdd(ResourceLocation loc)
	{
		if(!textures.contains(loc)) textures.add(loc);
	}
}