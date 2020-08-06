package dev.toma.pubgmc;

import dev.toma.pubgmc.client.ScopeInfo;
import dev.toma.pubgmc.client.animation.gun.GunAnimations;
import dev.toma.pubgmc.client.model.baked.DummyBakedModel;
import dev.toma.pubgmc.client.model.baked.DummyGunBakedModel;
import dev.toma.pubgmc.client.render.item.GunRenderer;
import dev.toma.pubgmc.client.render.item.VehicleSpawnerRenderer;
import dev.toma.pubgmc.common.block.AirdropBlock;
import dev.toma.pubgmc.common.block.LootSpawnerBlock;
import dev.toma.pubgmc.common.block.PMCHorizontalBlock;
import dev.toma.pubgmc.common.block.crafting.AmmoFactoryBlock;
import dev.toma.pubgmc.common.block.crafting.WeaponFactoryBlock;
import dev.toma.pubgmc.common.entity.BulletEntity;
import dev.toma.pubgmc.common.entity.ParachuteEntity;
import dev.toma.pubgmc.common.entity.throwable.FlashEntity;
import dev.toma.pubgmc.common.entity.throwable.GrenadeEntity;
import dev.toma.pubgmc.common.entity.throwable.MolotovEntity;
import dev.toma.pubgmc.common.entity.throwable.SmokeEntity;
import dev.toma.pubgmc.common.entity.vehicle.AirDriveableEntity;
import dev.toma.pubgmc.common.entity.vehicle.LandDriveableEntity;
import dev.toma.pubgmc.common.item.PMCItem;
import dev.toma.pubgmc.common.item.gun.AmmoType;
import dev.toma.pubgmc.common.item.gun.Firemode;
import dev.toma.pubgmc.common.item.gun.GunItem;
import dev.toma.pubgmc.common.item.gun.ReloadManager;
import dev.toma.pubgmc.common.item.gun.attachment.AttachmentCategory;
import dev.toma.pubgmc.common.item.gun.attachment.AttachmentItem;
import dev.toma.pubgmc.common.item.healing.*;
import dev.toma.pubgmc.common.item.utility.*;
import dev.toma.pubgmc.common.item.wearable.BulletProofArmor;
import dev.toma.pubgmc.init.PMCItems;
import dev.toma.pubgmc.init.PMCSounds;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RegistryHandler {

    @Mod.EventBusSubscriber(modid = Pubgmc.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class CommonHandler {

        @SubscribeEvent
        public static void onItemRegister(RegistryEvent.Register<Item> event) {
            IForgeRegistry<Item> registry = event.getRegistry();
            registry.registerAll(
                    new BandageItem("bandage"),
                    new FirstAidKitItem("first_aid_kit"),
                    new MedkitItem("medkit"),
                    new EnergyDrinkItem("energy_drink"),
                    new PainkillerItem("painkillers"),
                    new AdrenalineSyringeItem("adrenaline_syringe"),
                    new BulletProofArmor("basic_helmet", 0.7F, BulletProofArmor.Material.BASIC, EquipmentSlotType.HEAD).textureMap(0, 0, 0, 1),
                    new BulletProofArmor("basic_vest", 0.7F, BulletProofArmor.Material.BASIC, EquipmentSlotType.CHEST).textureMap(3, 0, 3, 1),
                    new BulletProofArmor("police_helmet", 0.6F, BulletProofArmor.Material.POLICE, EquipmentSlotType.HEAD).textureMap(1, 0, 1, 1),
                    new BulletProofArmor("police_vest", 0.6F, BulletProofArmor.Material.POLICE, EquipmentSlotType.CHEST).textureMap(4, 0, 4, 1),
                    new BulletProofArmor("military_helmet", 0.45F, BulletProofArmor.Material.MILITARY, EquipmentSlotType.HEAD).textureMap(2, 0, 2, 1),
                    new BulletProofArmor("military_vest", 0.45F, BulletProofArmor.Material.MILITARY, EquipmentSlotType.CHEST).textureMap(5, 0, 5, 1),
                    new ParachuteItem("parachute"),
                    new ThrowableItem("grenade", 100, GrenadeEntity::new),
                    new ThrowableItem("smoke", 20, SmokeEntity::new),
                    new ThrowableItem("molotov", 0, MolotovEntity::new),
                    new ThrowableItem("flash", 100, FlashEntity::new),
                    new VehicleSpawnerItem("spawn_uaz", LandDriveableEntity.UAZDriveable::new, new Item.Properties().maxStackSize(1).group(PMCItem.ITEMS).setTEISR(() -> VehicleSpawnerRenderer::new)),
                    new VehicleSpawnerItem("spawn_glider", AirDriveableEntity.GliderDriveable::new, new Item.Properties().maxStackSize(1).group(PMCItem.ITEMS).setTEISR(() -> VehicleSpawnerRenderer::new)),
                    new FuelCanItem("fuel_can"),
                    new AmmoItem("crossbow_bolt", AmmoType.CROSSBOW_BOLT),
                    new AmmoItem("ammo_12g", AmmoType.AMMO_12G),
                    new AmmoItem("ammo_9mm", AmmoType.AMMO_9MM),
                    new AmmoItem("ammo_45acp", AmmoType.AMMO_45ACP),
                    new AmmoItem("ammo_556mm", AmmoType.AMMO_556MM),
                    new AmmoItem("ammo_762mm", AmmoType.AMMO_762MM),
                    new AmmoItem("ammo_300m", AmmoType.AMMO_300M),
                    new AttachmentItem.Barrel("shotgun_choke", 1.0F, 1.0F, false, 0.5F),
                    new AttachmentItem.Barrel("suppressor_smg", true),
                    new AttachmentItem.Barrel("compensator_smg", 0.7F, 0.7F, false),
                    new AttachmentItem.Barrel("suppressor_ar", true),
                    new AttachmentItem.Barrel("compensator_ar", 0.7F, 0.7F, false),
                    new AttachmentItem.Barrel("suppressor_sr", true),
                    new AttachmentItem.Barrel("compensator_sr", 0.7F, 0.7F, false),
                    new AttachmentItem.Grip("angled_grip", 0.95F, 0.7F),
                    new AttachmentItem.Grip("vertical_grip", 0.7F, 0.95F),
                    new AttachmentItem.Magazine("quickdraw_smg", true, false),
                    new AttachmentItem.Magazine("extended_smg", false, true),
                    new AttachmentItem.Magazine("quickdraw_extended_smg", true, true),
                    new AttachmentItem.Magazine("quickdraw_ar", true, false),
                    new AttachmentItem.Magazine("extended_ar", false, true),
                    new AttachmentItem.Magazine("quickdraw_extended_ar", true, true),
                    new AttachmentItem.Magazine("quickdraw_sr", true, false),
                    new AttachmentItem.Magazine("extended_sr", false, true),
                    new AttachmentItem.Magazine("quickdraw_extended_sr", true, true),
                    new AttachmentItem.Stock("folding_stock", false, 1.25F),
                    new AttachmentItem.Stock("tactical_stock", false, 1.25F),
                    new AttachmentItem.Stock("cheekpad", false, 1.25F),
                    new AttachmentItem.Stock("bullet_loops", true, 1.0F),
                    new AttachmentItem.Scope("red_dot", new ScopeInfo(ScopeInfo.OVERLAY_RED_DOT)),
                    new AttachmentItem.Scope("holographic", new ScopeInfo(ScopeInfo.OVERLAY_HOLOGRAPHIC)),
                    new AttachmentItem.Scope("x2_scope", new ScopeInfo(ScopeInfo.OVERLAY_2X, 34)),
                    new AttachmentItem.Scope("x3_scope", new ScopeInfo(ScopeInfo.OVERLAY_3X, 26)),
                    new AttachmentItem.Scope("x4_scope", new ScopeInfo(ScopeInfo.OVERLAY_4X, 20)),
                    new AttachmentItem.Scope("x6_scope", new ScopeInfo(ScopeInfo.OVERLAY_6X, 16)),
                    new AttachmentItem.Scope("x8_scope", new ScopeInfo(ScopeInfo.OVERLAY_8X, 12)),
                    new AttachmentItem.Scope("x15_scope", new ScopeInfo(ScopeInfo.OVERLAY_15X, 8)),
                    new GunItem.GunBuilder()
                            .gunProperties(4.0F, 2.5F, 11.0F, 0.05F, 3)
                            .recoil(1.5F, 0.75F)
                            .firerate(2)
                            .firemodes(Firemode.SINGLE, Firemode::singleMode)
                            .ammo(AmmoType.AMMO_9MM, (p92, stack) -> p92.getAttachment(AttachmentCategory.MAGAZINE, stack).isExtended() ? 20 : 15)
                            .reload(ReloadManager.Magazine.instance, isQuickdraw -> isQuickdraw ? 30 : 40)
                            .ister(() -> GunRenderer.P92Renderer::new)
                            .attachments()
                                .barrel(() -> new AttachmentItem.Barrel[] {PMCItems.SUPPRESSOR_SMG})
                                .scope(() -> new AttachmentItem.Scope[] {PMCItems.RED_DOT, PMCItems.HOLOGRAPHIC})
                                .magazine(() -> new AttachmentItem.Magazine[] {PMCItems.QUICKDRAW_SMG, PMCItems.EXTENDED_SMG, PMCItems.QUICKDRAW_EXTENDED_SMG})
                            .build()
                            .animations(() -> () -> GunAnimations.PistolAnimations::new)
                            .shootingSound(silenced -> silenced ? PMCSounds.P92_SHOOT_SILENT : PMCSounds.P92_SHOOT)
                            .reloadingSound(quickdraw -> quickdraw ? PMCSounds.P92_RELOAD_FAST : PMCSounds.P92_RELOAD)
                            .shootingVolume(silenced -> silenced ? 5.0F : 9.0F)
                            .build("p92")
            );
            blockItemList.stream().filter(Objects::nonNull).forEach(registry::register);
            blockItemList = null;
        }

        public static List<BlockItem> blockItemList = new ArrayList<>();

        @SubscribeEvent
        public static void onBlockRegister(RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    new PMCHorizontalBlock("generator", Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F)),
                    new PMCHorizontalBlock("storage", Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F)),
                    new PMCHorizontalBlock("interface", Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F)),
                    new PMCHorizontalBlock("producer", Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2.5F)),
                    new WeaponFactoryBlock("weapon_factory"),
                    new AmmoFactoryBlock("ammo_factory"),
                    new LootSpawnerBlock("loot_spawner"),
                    new AirdropBlock("airdrop")
            );
        }

        @SubscribeEvent
        public static void onEntityTypeRegister(RegistryEvent.Register<EntityType<?>> event) {
            event.getRegistry().registerAll(
                    registerEntity("parachute", track_builder(ParachuteEntity::new, EntityClassification.MISC, 256).size(1.5F, 2.5F)),
                    registerEntity("grenade", track_builder(GrenadeEntity::new, EntityClassification.MISC, 32).size(0.2F, 0.2F)),
                    registerEntity("smoke", track_builder(SmokeEntity::new, EntityClassification.MISC, 32).size(0.2F, 0.2F)),
                    registerEntity("molotov", track_builder(MolotovEntity::new, EntityClassification.MISC, 32).size(0.2F, 0.2F)),
                    registerEntity("flash", track_builder(FlashEntity::new, EntityClassification.MISC, 32).size(0.2F, 0.2F)),
                    registerEntity("uaz", track_builder(LandDriveableEntity.UAZDriveable::new, EntityClassification.MISC, 64).size(2.25F, 2.0F)),
                    registerEntity("glider", track_builder(AirDriveableEntity.GliderDriveable::new, EntityClassification.MISC, 64).size(2.5F, 2.0F)),
                    registerEntity("bullet", track_builder(BulletEntity::new, EntityClassification.MISC, 64).size(0.1F, 0.1F))
            );
        }

        @SubscribeEvent
        public static void onSoundRegister(RegistryEvent.Register<SoundEvent> event) {
            event.getRegistry().registerAll(
                sound("p92_shoot"),
                sound("p92_shoot_silent"),
                sound("p92_reload"),
                sound("p92_reload_fast")
            );
        }

        private static SoundEvent sound(String key) {
            ResourceLocation location = Pubgmc.makeResource(key);
            return new SoundEvent(location).setRegistryName(location);
        }

        private static <T extends Entity> EntityType<T> registerEntity(String name, EntityType.Builder<T> builder) {
            EntityType<T> type = builder.build(Pubgmc.MODID + ":" + name);
            type.setRegistryName(Pubgmc.makeResource(name));
            return type;
        }

        private static <T extends Entity> EntityType.Builder<T> builder(EntityType.IFactory<T> factory, EntityClassification classification) {
            return EntityType.Builder.create(factory, classification);
        }

        private static <T extends Entity> EntityType.Builder<T> track_builder(EntityType.IFactory<T> factory, EntityClassification classification, int range) {
            return EntityType.Builder.create(factory, classification).setTrackingRange(range).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true);
        }
    }

    @Mod.EventBusSubscriber(modid = Pubgmc.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientHandler {

        @SubscribeEvent
        public static void bake(ModelBakeEvent event) {
            Map<ResourceLocation, IBakedModel> registry = event.getModelRegistry();
            IBakedModel model = new DummyBakedModel();
            registry.put(get(PMCItems.SPAWN_UAZ), model);
            registry.put(get(PMCItems.SPAWN_GLIDER), model);

            DummyGunBakedModel gunBakedModel = new DummyGunBakedModel();
            ForgeRegistries.ITEMS.getValues()
                    .stream()
                    .filter(item -> item instanceof GunItem)
                    .forEach(item -> registry.put(get(item), gunBakedModel));
        }

        public static ModelResourceLocation get(Item item) {
            // debug purposes
            return new ModelResourceLocation(item == null ? new ResourceLocation("unknown", "null") : item.getRegistryName(), "inventory");
        }
    }
}