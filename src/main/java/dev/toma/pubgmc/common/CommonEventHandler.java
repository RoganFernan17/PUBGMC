package dev.toma.pubgmc.common;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.capability.IPlayerCap;
import dev.toma.pubgmc.capability.PMCInventoryHandler;
import dev.toma.pubgmc.capability.player.InventoryFactory;
import dev.toma.pubgmc.capability.player.InventoryProvider;
import dev.toma.pubgmc.capability.player.PlayerCapFactory;
import dev.toma.pubgmc.capability.player.PlayerCapProvider;
import dev.toma.pubgmc.capability.world.WorldDataProvider;
import dev.toma.pubgmc.common.inventory.SlotType;
import dev.toma.pubgmc.common.item.gun.core.AbstractGunItem;
import dev.toma.pubgmc.common.item.utility.BackpackSlotItem;
import dev.toma.pubgmc.network.NetworkManager;
import dev.toma.pubgmc.network.packet.CPacketSendRecipes;
import dev.toma.pubgmc.network.packet.CPacketSyncInventory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = Pubgmc.MODID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void livingChangeEquipment(LivingEquipmentChangeEvent event) {
        LivingEntity entity = event.getEntityLiving();
        ItemStack stack = event.getTo();
        EquipmentSlotType slotType = event.getSlot();
        if(entity instanceof PlayerEntity) {
            if (stack.getItem() instanceof AbstractGunItem) {
                if(slotType == EquipmentSlotType.OFFHAND) {
                    ItemStack copyOf = stack.copy();
                    stack.setCount(0);
                    if(!entity.world.isRemote) {
                        ItemEntity itemEntity = new ItemEntity(entity.world, entity.posX, entity.posY, entity.posZ, copyOf);
                        itemEntity.setPickupDelay(0);
                        entity.world.addEntity(itemEntity);
                    }
                } else if(slotType == EquipmentSlotType.MAINHAND) {
                    ((AbstractGunItem) stack.getItem()).onEquip(entity, entity.world, stack);
                }
            }
        }
    }

    @SubscribeEvent
    public static void attachEntityCap(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof PlayerEntity) {
            event.addCapability(Pubgmc.makeResource("playercap"), new PlayerCapProvider((PlayerEntity) event.getObject()));
            event.addCapability(Pubgmc.makeResource("inv"), new InventoryProvider(new InventoryFactory((PlayerEntity) event.getObject())));
        }
    }

    @SubscribeEvent
    public static void attachWorldCap(AttachCapabilitiesEvent<World> event) {
        event.addCapability(Pubgmc.makeResource("world_data"), new WorldDataProvider(event.getObject()));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        IPlayerCap cap = PlayerCapFactory.get(player);
        boolean b = cap.isProne();
        player.abilities.walkSpeed = b ? 0.045F : 0.1F;
        if(b) {
            player.setPose(Pose.STANDING);
            AxisAlignedBB proneBB = new AxisAlignedBB(player.posX - 0.6, player.posY, player.posZ - 0.6, player.posX + 0.6, player.posY + 0.8, player.posZ + 0.6);
            player.setBoundingBox(proneBB);
            player.eyeHeight = 0.6F;
            player.size = IPlayerCap.PRONE_SIZE;
        }
        if(event.phase == TickEvent.Phase.END) {
            cap.onTick();
            PMCInventoryHandler handler = InventoryFactory.getInventoryHandler(player);
            if(!player.world.isRemote) {
                sync(player, handler);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerLogIn(PlayerEvent.PlayerLoggedInEvent event) {
        IPlayerCap cap = PlayerCapFactory.get(event.getPlayer());
        cap.syncAllData();
        NetworkManager.sendToClient((ServerPlayerEntity) event.getPlayer(), new CPacketSendRecipes(Pubgmc.getRecipeManager().recipeMap));
        syncInventory(event.getPlayer(), Collections.singletonList(event.getPlayer()));
    }

    @SubscribeEvent
    public static void onLogOut(PlayerEvent.PlayerLoggedOutEvent event) {
        syncMap.remove(event.getPlayer().getUniqueID());
    }

    @SubscribeEvent
    public static void clonePlayer(PlayerEvent.Clone event) {
        try {
            InventoryFactory oldData = (InventoryFactory) InventoryFactory.getInventoryHandler(event.getOriginal());
            InventoryFactory createdData = (InventoryFactory) InventoryFactory.getInventoryHandler(event.getPlayer());
            createdData.deserializeNBT(oldData.serializeNBT());
            IPlayerCap oldCap = PlayerCapFactory.get(event.getOriginal());
            IPlayerCap newCap = PlayerCapFactory.get(event.getPlayer());
            newCap.deserializeNBT(oldCap.serializeNBT());
            newCap.syncNetworkData();
        } catch (Exception e) {
            Pubgmc.pubgmcLog.error("Exception cloning player data: {}", e.toString());
        }
    }

    @SubscribeEvent
    public static void startTracking(PlayerEvent.StartTracking event) {
        Entity entity = event.getTarget();
        if(entity instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) entity;
            syncInventory(player, Collections.singletonList(player));
        }
    }

    @SubscribeEvent
    public static void onPlayerDeath(LivingDropsEvent event) {
        if(event.getEntity() instanceof PlayerEntity) {
            World world = event.getEntity().world;
            GameRules rules = world.getGameRules();
            if(!world.isRemote && !rules.getBoolean(GameRules.KEEP_INVENTORY)) {
                dropItems((PlayerEntity) event.getEntity(), event.getDrops());
            }
        }
    }

    @SubscribeEvent
    public static void pickupItem(EntityItemPickupEvent event) {
        ItemStack stack = event.getItem().getItem();
        PlayerInventory inventory = event.getPlayer().inventory;
        int slot = findFirstSuitableSlot(inventory, stack);
        event.setResult(Event.Result.DENY);
        if(slot > 0) {
            PlayerEntity player = inventory.player;
            if(slot >= 9) {
                int row = (slot - 9) / 9;
                ItemStack backpack = InventoryFactory.getStackInSlot(player, SlotType.BACKPACK);
                if(backpack.isEmpty() || !(backpack.getItem() instanceof BackpackSlotItem)) {
                    event.setCanceled(true);
                    return;
                } else {
                    int type = 2 - ((BackpackSlotItem) backpack.getItem()).getType().ordinal();
                    if(row < type) {
                        event.setCanceled(true);
                        return;
                    }
                }
            }
            event.setResult(Event.Result.DEFAULT);
            ItemStack itemStack = inventory.getStackInSlot(slot);
            if(itemStack.isEmpty()) {
                event.setCanceled(true);
                player.onItemPickup(event.getItem(), stack.getCount());
                event.getItem().remove();
                inventory.setInventorySlotContents(slot, stack.copy());
            } else {
                int amountInInventory = itemStack.getCount();
                int insertAmount = stack.getCount();
                int total = amountInInventory + insertAmount;
                if(total <= itemStack.getMaxStackSize()) {
                    itemStack.setCount(total);
                    stack.setCount(0);
                } else {
                    int extra = total - itemStack.getMaxStackSize();
                    ItemStack leftOut = stack.copy();
                    itemStack.setCount(itemStack.getMaxStackSize());
                    stack.setCount(0);
                    leftOut.setCount(extra);
                    World world = player.world;
                    if(!world.isRemote) {
                        ItemEntity itemEntity = new ItemEntity(world, player.posX, player.posY, player.posZ, leftOut);
                        itemEntity.setPickupDelay(0);
                        world.addEntity(itemEntity);
                    }
                }
            }
        }
    }

    private static int findFirstSuitableSlot(PlayerInventory inventory, ItemStack stack) {
        for(int i = 0; i < inventory.getSizeInventory(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if(!itemStack.isEmpty() && ItemStack.areItemsEqual(stack, itemStack) && itemStack.getCount() < itemStack.getMaxStackSize()) {
                return i;
            }
        }
        // hotbar
        for (int i = 0; i < 9; i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if(isValidSlotForStack(stack, itemStack)) {
                return i;
            }
        }
        // inventory
        for(int i = 35; i >= 9; i--) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if(isValidSlotForStack(stack, itemStack)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValidSlotForStack(ItemStack stack, ItemStack inInventory) {
        return inInventory.isEmpty() || (ItemStack.areItemsEqual(stack, inInventory) && inInventory.getCount() < inInventory.getMaxStackSize());
    }

    private static final Map<UUID, ItemStack[]> syncMap = new HashMap<>();
    private static final boolean autoSync = true;

    private static void sync(PlayerEntity player, PMCInventoryHandler handler) {
        ItemStack[] stacks = syncMap.get(player.getUniqueID());
        if(stacks == null) {
            stacks = new ItemStack[handler.getSlots()];
            Arrays.fill(stacks, ItemStack.EMPTY);
            syncMap.put(player.getUniqueID(), stacks);
        }
        Set<PlayerEntity> players = null;
        for(int i = 0; i < handler.getSlots(); i++) {
            ItemStack stack = handler.getStackInSlot(i);
            if(autoSync && handler.hasChanged(i) && !ItemStack.areItemStacksEqual(stack, stacks[i])) {
                if(players == null) {
                    players = new HashSet<>(player.world.getPlayers());
                }
                syncSlot(player, i, stack, players);
                handler.setChanged(i, false);
                stacks[i] = stack == null ? ItemStack.EMPTY : stack.copy();
            }
        }
    }

    private static void syncInventory(PlayerEntity player, Collection<? extends PlayerEntity> receiveUpdate) {
        PMCInventoryHandler inventoryHandler = InventoryFactory.getInventoryHandler(player);
        for (int s = 0; s < inventoryHandler.getSlots(); s++) {
            syncSlot(player, s, inventoryHandler.getStackInSlot(s), receiveUpdate);
        }
    }

    private static void syncSlot(PlayerEntity player, int slot, ItemStack stack, Collection<? extends PlayerEntity> receiveUpdate) {
        CPacketSyncInventory cPacketSyncInventory = new CPacketSyncInventory(player.getEntityId(), slot, stack);
        for(PlayerEntity receiver : receiveUpdate) {
            NetworkManager.sendToClient((ServerPlayerEntity) receiver, cPacketSyncInventory);
        }
    }

    private static void dropItems(PlayerEntity player, Collection<ItemEntity> items) {
        PMCInventoryHandler handler = InventoryFactory.getInventoryHandler(player);
        for(int i = 0; i < handler.getSlots(); i++) {
            ItemStack stack = handler.getStackInSlot(i);
            if(!stack.isEmpty()) {
                World world = player.world;
                ItemEntity ie = new ItemEntity(world, player.posX, player.posY + player.getEyeHeight(), player.posZ, stack.copy());
                ie.setPickupDelay(40);
                float f1 = world.rand.nextFloat() * 0.5F;
                float f2 = world.rand.nextFloat() * (float) Math.PI * 2.0F;
                ie.setMotion(-MathHelper.sin(f2) * f1, 0.2, MathHelper.cos(f2) * f1);
                items.add(ie);
                handler.setStackInSlot(i, ItemStack.EMPTY);
            }
        }
    }
}
