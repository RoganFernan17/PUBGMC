package com.toma.pubgmc.common.blocks;

import java.util.Random;

import com.toma.pubgmc.ConfigPMC;
import com.toma.pubgmc.Pubgmc;
import com.toma.pubgmc.common.tileentity.TileEntityAirdrop;
import com.toma.pubgmc.util.handlers.GuiHandler;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAirdrop extends PMCBlock
{
	private MapColor color;
	
	public BlockAirdrop(String name, Material material, SoundType sound, MapColor color)
	{
		super(name, material);
		this.setSoundType(sound);
		this.color = color;
	}
	
	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return color;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if(!worldIn.isRemote && ConfigPMC.common.worldSettings.airdropLootGen > 0)
		{
			TileEntity tilee = worldIn.getTileEntity(pos);
			if(tilee instanceof TileEntityAirdrop)
			{
				TileEntityAirdrop te = (TileEntityAirdrop)tilee;
				te.generateLoot();
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{
		if(!worldIn.isRemote && !playerIn.isSneaking())
		{
			playerIn.openGui(Pubgmc.instance, GuiHandler.GUI_AIRDROP, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) 
	{
		return new ItemStack(Items.IRON_INGOT);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Items.IRON_INGOT;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		return 1 + random.nextInt(5);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
	{
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state)
	{
		return new TileEntityAirdrop();
	}

}
