package dev.toma.pubgmc.common.item.wearable;

import dev.toma.pubgmc.capability.PMCInventoryHandler;
import dev.toma.pubgmc.capability.player.InventoryFactory;
import dev.toma.pubgmc.common.item.PMCItem;
import dev.toma.pubgmc.common.item.utility.GhillieSlotItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class GhillieSuitItem extends PMCItem implements GhillieSlotItem, IDyeableArmorItem {

    public GhillieSuitItem(String name) {
        super(name, new Properties().maxStackSize(1).group(ITEMS));
    }

    @Override
    public boolean hasColor(ItemStack stack) {
        return stack.hasTag() && stack.getTag().contains("color", Constants.NBT.TAG_INT);
    }

    @Override
    public void setColor(ItemStack stack, int color) {
        CompoundNBT nbt;
        if(!stack.hasTag()) {
            nbt = new CompoundNBT();
            stack.setTag(nbt);
        }
        nbt = stack.getTag();
        nbt.putInt("color", color);
    }

    @Override
    public void removeColor(ItemStack stack) {
        if(hasColor(stack)) {
            stack.getTag().remove("color");
        }
    }

    @Override
    public int getColor(ItemStack stack) {
        if(!stack.hasTag()) {
            return getDefaultColor();
        }
        CompoundNBT nbt = stack.getTag();
        if(!nbt.contains("color")) {
            return getDefaultColor();
        } else return Math.abs(nbt.getInt("color"));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        PMCInventoryHandler handler = InventoryFactory.getInventoryHandler(playerIn);
        ItemStack stack = playerIn.getHeldItem(handIn);
        ItemStack ghillieSlot = handler.getStackInSlot(1);
        if(ghillieSlot.isEmpty()) {
            handler.setStackInSlot(1, stack.copy());
            stack.shrink(1);
            return ActionResult.newResult(ActionResultType.SUCCESS, stack);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public boolean blocksBackpackRender() {
        return true;
    }

    public static int getDefaultColor() {
        return 0x6B8B42;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(this.isInGroup(group)) {
            items.add(new ItemStack(this));
            CompoundNBT white = new CompoundNBT();
            white.putInt("color", 0xffffff);
            ItemStack whiteGhillie = new ItemStack(this);
            whiteGhillie.setTag(white);
            items.add(whiteGhillie);
        }
    }
}
