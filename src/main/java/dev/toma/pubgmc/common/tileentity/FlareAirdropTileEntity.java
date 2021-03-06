package dev.toma.pubgmc.common.tileentity;

import dev.toma.pubgmc.common.container.FlareAirdropContainer;
import dev.toma.pubgmc.data.loot.LootManager;
import dev.toma.pubgmc.data.loot.LootTable;
import dev.toma.pubgmc.data.loot.LootTableConstants;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.List;

import static dev.toma.pubgmc.init.PMCTileEntities.FLARE_AIRDROP;

public class FlareAirdropTileEntity extends AirdropTileEntity {

    public FlareAirdropTileEntity() {
        super(FLARE_AIRDROP.get());
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        return new FlareAirdropContainer(id, playerInventory, this);
    }

    @Override
    public IItemHandler createInventory() {
        return new ItemStackHandler(18);
    }

    @Override
    public void generateLoot() {
        clearInventory();
        inventory.ifPresent(inv -> {
            LootTable gun = LootManager.getLootTable(LootTableConstants.AIRDROP_WEAPONS);
            LootTable util = LootManager.getLootTable(LootTableConstants.AIRDROP_UTILITIES);
            int at = 0;
            if (!gun.isEmpty()) {
                for(int i = 0; i < 2; i++) {
                    List<ItemStack> stacks = gun.getLoot(world.rand, false);
                    for(ItemStack stack : stacks) {
                        if(at >= inv.getSlots()) break;
                        inv.insertItem(at, stack, false);
                        ++at;
                        at = postItemGenerated(stack, at, inventory);
                    }
                }
            }
            if (!util.isEmpty()) {
                for (int i = 0; i < 2; i++) {
                    List<ItemStack> stacks = util.getLoot(world.rand, false);
                    for(ItemStack stack : stacks) {
                        if(at >= inv.getSlots()) break;
                        inv.insertItem(at, stack, false);
                        ++at;
                    }
                }
            }
        });
    }
}
