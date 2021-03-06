package dev.toma.pubgmc.init;

import dev.toma.pubgmc.Pubgmc;
import dev.toma.pubgmc.common.tileentity.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PMCTileEntities {
    public static final DeferredRegister<TileEntityType<?>> TE_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Pubgmc.MODID);
    public static final RegistryObject<TileEntityType<LootSpawnerTileEntity>> LOOT_SPAWNER = TE_TYPES.register("loot_spawner", () -> TileEntityType.Builder.create(LootSpawnerTileEntity::new, PMCBlocks.LOOT_SPAWNER).build(null));
    public static final RegistryObject<TileEntityType<AirdropTileEntity>> AIRDROP = TE_TYPES.register("airdrop", () -> TileEntityType.Builder.create(AirdropTileEntity::new, PMCBlocks.AIRDROP).build(null));
    public static final RegistryObject<TileEntityType<FlareAirdropTileEntity>> FLARE_AIRDROP = TE_TYPES.register("flare_airdrop", () -> TileEntityType.Builder.create(FlareAirdropTileEntity::new, PMCBlocks.FLARE_AIRDROP).build(null));
    public static final RegistryObject<TileEntityType<AbstractFactoryTileEntity.Weapon>> WEAPON_FACTORY = TE_TYPES.register("weapon_factory", () -> TileEntityType.Builder.create(AbstractFactoryTileEntity.Weapon::new, PMCBlocks.WEAPON_FACTORY).build(null));
    public static final RegistryObject<TileEntityType<AbstractFactoryTileEntity.Ammo>> AMMO_FACTORY = TE_TYPES.register("ammo_factory", () -> TileEntityType.Builder.create(AbstractFactoryTileEntity.Ammo::new, PMCBlocks.AMMO_FACTORY).build(null));
    public static final RegistryObject<TileEntityType<DeathCrateTileEntity>> DEATH_CRATE = TE_TYPES.register("death_crate", () -> TileEntityType.Builder.create(DeathCrateTileEntity::new, PMCBlocks.DEATH_CRATE).build(null));
}
