package com.maxvillage;

import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

@Mod(MaxVillage.MODID)
public class MaxVillage {
    public static final String MODID = "maxvillage";
    private static final Logger LOGGER = LogManager.getLogger();

    public MaxVillage() {
        // Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
        LOGGER.info("MaxVillage mod initialized");
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("MaxVillage: Setting up structure configurations");
            setupStructures();
        });
    }

    private void setupStructures() {
        try {
            // Update structure separation settings based on config
            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(DimensionStructuresSettings.DEFAULTS);
            
            // Village
            updateStructureSettings(tempMap, Structure.VILLAGE,
                    Config.COMMON.villageSpacing.get(),
                    Config.COMMON.villageSeparation.get());
            
            // Desert Pyramid
            updateStructureSettings(tempMap, Structure.DESERT_PYRAMID,
                    Config.COMMON.desertPyramidSpacing.get(),
                    Config.COMMON.desertPyramidSeparation.get());
            
            // Jungle Temple
            updateStructureSettings(tempMap, Structure.JUNGLE_TEMPLE,
                    Config.COMMON.jungleTempleSpacing.get(),
                    Config.COMMON.jungleTempleSeparation.get());
            
            // Swamp Hut
            updateStructureSettings(tempMap, Structure.SWAMP_HUT,
                    Config.COMMON.swampHutSpacing.get(),
                    Config.COMMON.swampHutSeparation.get());
            
            // Igloo
            updateStructureSettings(tempMap, Structure.IGLOO,
                    Config.COMMON.iglooSpacing.get(),
                    Config.COMMON.iglooSeparation.get());
            
            // Ocean Monument
            updateStructureSettings(tempMap, Structure.OCEAN_MONUMENT,
                    Config.COMMON.oceanMonumentSpacing.get(),
                    Config.COMMON.oceanMonumentSeparation.get());
            
            // Shipwreck
            updateStructureSettings(tempMap, Structure.SHIPWRECK,
                    Config.COMMON.shipwreckSpacing.get(),
                    Config.COMMON.shipwreckSeparation.get());
            
            // Ocean Ruins
            updateStructureSettings(tempMap, Structure.OCEAN_RUIN,
                    Config.COMMON.oceanRuinsSpacing.get(),
                    Config.COMMON.oceanRuinsSeparation.get());
            
            // Pillager Outpost
            updateStructureSettings(tempMap, Structure.PILLAGER_OUTPOST,
                    Config.COMMON.pillagerOutpostSpacing.get(),
                    Config.COMMON.pillagerOutpostSeparation.get());
            
            // Mansion
            updateStructureSettings(tempMap, Structure.WOODLAND_MANSION,
                    Config.COMMON.mansionSpacing.get(),
                    Config.COMMON.mansionSeparation.get());
            
            // Nether Fortress
            updateStructureSettings(tempMap, Structure.NETHER_BRIDGE,
                    Config.COMMON.netherFortressSpacing.get(),
                    Config.COMMON.netherFortressSeparation.get());
            
            // End City
            updateStructureSettings(tempMap, Structure.END_CITY,
                    Config.COMMON.endCitySpacing.get(),
                    Config.COMMON.endCitySeparation.get());

            // Apply the updated settings
            DimensionStructuresSettings.DEFAULTS = tempMap;
            
            LOGGER.info("MaxVillage: Structure configurations applied successfully");
        } catch (Exception e) {
            LOGGER.error("MaxVillage: Error setting up structure configurations", e);
        }
    }

    private void updateStructureSettings(Map<Structure<?>, StructureSeparationSettings> map,
                                         Structure<?> structure, int spacing, int separation) {
        StructureSeparationSettings defaultSettings = map.get(structure);
        if (defaultSettings != null) {
            int salt = defaultSettings.salt();
            StructureSeparationSettings newSettings = new StructureSeparationSettings(spacing, separation, salt);
            map.put(structure, newSettings);
            LOGGER.debug("Updated {} - Spacing: {}, Separation: {}", 
                    structure.getRegistryName(), spacing, separation);
        }
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        // Additional world-specific setup can be done here if needed
        LOGGER.debug("MaxVillage: World loaded");
    }
}
