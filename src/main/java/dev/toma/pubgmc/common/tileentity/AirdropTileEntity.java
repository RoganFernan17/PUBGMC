package dev.toma.pubgmc.common.tileentity;

import dev.toma.pubgmc.common.container.AirdropContainer;
import dev.toma.pubgmc.config.Config;
import dev.toma.pubgmc.data.loot.LootManager;
import dev.toma.pubgmc.data.loot.LootTable;
import dev.toma.pubgmc.data.loot.LootTableConstants;
import dev.toma.pubgmc.games.interfaces.ILootGenerator;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

import static dev.toma.pubgmc.init.PMCTileEntities.AIRDROP;

public class AirdropTileEntity extends AbstractInventoryTileEntity implements ILootGenerator {

    private long id = -1;

    public AirdropTileEntity() {
        this(AIRDROP.get());
    }

    public AirdropTileEntity(TileEntityType<?> type) {
        super(type);
    }

    @Override
    public IItemHandler createInventory() {
        return new ItemStackHandler(9);
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return new AirdropContainer(p_createMenu_1_, p_createMenu_2_, this);
    }

    @Override
    public void generateLoot() {
        clearInventory();
        inventory.ifPresent(inv -> {
            LootTable gun = LootManager.getLootTable(LootTableConstants.AIRDROP_WEAPONS);
            LootTable util = LootManager.getLootTable(LootTableConstants.AIRDROP_UTILITIES);
            int at = 0;
            if(!gun.isEmpty()) {
                List<ItemStack> gunStack = gun.getLoot(world.rand, false);
                for(ItemStack stack : gunStack) {
                    if(at >= inv.getSlots()) break;
                    inv.insertItem(at, stack, false);
                    ++at;
                    at = postItemGenerated(stack, at, inventory);
                }
            }
            if(!util.isEmpty()) {
                List<ItemStack> list = util.getLoot(world.rand, false);
                for(ItemStack stack : list) {
                    if(at >= inv.getSlots()) break;
                    inv.insertItem(at, stack, false);
                    ++at;
                }
            }
        });
    }

    @Override
    public void onExecuteLootGenCommand() {
        if(Config.cmdGeneratesAirdropLoot.get()) {
            generateLoot();
        }
    }

    @Override
    public void setGameID(long ID) {
        this.id = ID;
    }

    @Override
    public long getGameID() {
        return id;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putLong("gameID", id);
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        id = compound.getLong("gameID");
    }
}
