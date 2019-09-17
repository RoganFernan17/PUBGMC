package com.toma.pubgmc.common.tileentity;

import com.toma.pubgmc.api.IGameTileEntity;
import com.toma.pubgmc.common.items.guns.GunBase;
import com.toma.pubgmc.config.ConfigPMC;
import com.toma.pubgmc.config.common.CFGEnumAirdropLoot;
import com.toma.pubgmc.init.PMCRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileEntityBigAirdrop extends TileEntity implements IInventoryTileEntity, ITickable, IAirdropTileEntity, IGameTileEntity {
    private static final Random RANDOM = new Random();
    //LOOT GEN
    private static final List<ItemStack> WEAPONS = new ArrayList<ItemStack>();
    private static final List<ItemStack> HEALS = new ArrayList<ItemStack>();
    private static final List<ItemStack> ATACHMENTS = new ArrayList<ItemStack>();
    private NonNullList<ItemStack> inventory = NonNullList.<ItemStack>withSize(18, ItemStack.EMPTY);
    private int slot;
    private short timer;

    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString("Airdrop");
    }

    @Override
    public NonNullList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public String getName() {
        return this.getDisplayName().getFormattedText();
    }

    @Override
    public void generateLoot() {
        clear();
        if(ConfigPMC.common.world.airdropLoot == CFGEnumAirdropLoot.NOTHING) {
            return;
        }
        slot = -1;
        //setup
        generateWeaponLoot();
        generateAtachments();
        generateHeals();

        //2 sets of armor
        createArmorLoot();

        //2 weapons + ammo
        if(ConfigPMC.common.world.airdropLoot == CFGEnumAirdropLoot.ALL) {
            setInventorySlotContents(nextID(), WEAPONS.get(RANDOM.nextInt(WEAPONS.size())));
            addAmmoToCurrentWeapon();
            setInventorySlotContents(nextID(), WEAPONS.get(RANDOM.nextInt(WEAPONS.size())));
            addAmmoToCurrentWeapon();
            setInventorySlotContents(nextID(), ATACHMENTS.get(RANDOM.nextInt(ATACHMENTS.size())));
            setInventorySlotContents(nextID(), ATACHMENTS.get(RANDOM.nextInt(ATACHMENTS.size())));
        }

        //2 sets of heals and atachments
        setInventorySlotContents(nextID(), HEALS.get(RANDOM.nextInt(HEALS.size())));
        setInventorySlotContents(nextID(), HEALS.get(RANDOM.nextInt(HEALS.size())));

        generateGhillie();
    }

    private void addAmmoToCurrentWeapon() {
        switch (((GunBase) getStackInSlot(slot).getItem()).getAmmoType()) {
            case AMMO556: {
                for (int i = 0; i < 1 + RANDOM.nextInt(3); i++) {
                    setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.AMMO_556, 30));
                }

                break;
            }

            case AMMO762: {
                for (int i = 0; i < 1 + RANDOM.nextInt(3); i++) {
                    setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.AMMO_762, 30));
                }

                break;
            }

            case AMMO300M: {
                setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.AMMO_300M, 10));
                setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.AMMO_300M, 10));
                break;
            }

            default:
                break;
        }
    }

    private void generateWeaponLoot() {
        WEAPONS.clear();

        WEAPONS.add(new ItemStack(PMCRegistry.PMCItems.AUG));
        WEAPONS.add(new ItemStack(PMCRegistry.PMCItems.M249));
        WEAPONS.add(new ItemStack(PMCRegistry.PMCItems.GROZA));
        WEAPONS.add(new ItemStack(PMCRegistry.PMCItems.MK14));
        WEAPONS.add(new ItemStack(PMCRegistry.PMCItems.AWM));
    }

    private void generateAtachments() {
        ATACHMENTS.clear();

        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.EXTENDED_QUICKDRAW_MAG_AR));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.EXTENDED_QUICKDRAW_MAG_SNIPER));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.SILENCER_AR));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.SILENCER_SNIPER));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.COMPENSATOR_SNIPER));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.SCOPE4X));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.SCOPE8X));
        ATACHMENTS.add(new ItemStack(PMCRegistry.PMCItems.SCOPE15X));
    }

    private void generateHeals() {
        HEALS.clear();

        HEALS.add(new ItemStack(PMCRegistry.PMCItems.PAINKILLERS));
        HEALS.add(new ItemStack(PMCRegistry.PMCItems.FIRSTAIDKIT));
        HEALS.add(new ItemStack(PMCRegistry.PMCItems.MEDKIT));
        HEALS.add(new ItemStack(PMCRegistry.PMCItems.ADRENALINESYRINGE));
    }

    private void createArmorLoot() {
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.ARMOR3HELMET));
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.ARMOR3HELMET));
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.ARMOR3BODY));
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.ARMOR3BODY));
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.BACKPACK3));
        setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.BACKPACK3));
    }

    private void generateGhillie() {
        if (Math.random() * 100 <= 25) {
            setInventorySlotContents(nextID(), new ItemStack(PMCRegistry.PMCItems.GHILLIE_SUIT));
        }
    }

    private int nextID() {
        if (slot != 17) {
            slot++;
        }
        return slot;
    }

    @Override
    public void update() {
        if (timer++ >= 3 && world.isRemote && !inventory.isEmpty()) {
            timer = 0;
            world.spawnParticle(EnumParticleTypes.CLOUD, true, pos.getX() + 0.5, pos.getY() + 1.3, pos.getZ() + 0.5, 0.1, 0.06, 0.1, 0);
            world.spawnParticle(EnumParticleTypes.CLOUD, true, pos.getX() + 0.4, pos.getY() + 1.3, pos.getZ() + 0.6, 0.09, 0.04, 0.11, 0);
            world.spawnParticle(EnumParticleTypes.CLOUD, true, pos.getX() + 0.6, pos.getY() + 1.3, pos.getZ() + 0.4, 0.11, 0.05, 0.09, 0);
        }
    }

    private String hash;

    @Override
    public void setGameHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String getGameHash() {
        return hash;
    }

    @Override
    public void onLoaded() {
        world.scheduleBlockUpdate(pos, blockType, 3, 0);
    }
}
