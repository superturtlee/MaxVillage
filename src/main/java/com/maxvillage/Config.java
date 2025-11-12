package com.maxvillage;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MaxVillage.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        ForgeConfigSpec.Builder commonBuilder = new ForgeConfigSpec.Builder();
        COMMON = new Common(commonBuilder);
        COMMON_SPEC = commonBuilder.build();
    }

    public static class Common {
        // Village configuration
        public final ForgeConfigSpec.IntValue villageSpacing;
        public final ForgeConfigSpec.IntValue villageSeparation;
        
        // Desert Pyramid configuration
        public final ForgeConfigSpec.IntValue desertPyramidSpacing;
        public final ForgeConfigSpec.IntValue desertPyramidSeparation;
        
        // Jungle Temple configuration
        public final ForgeConfigSpec.IntValue jungleTempleSpacing;
        public final ForgeConfigSpec.IntValue jungleTempleSeparation;
        
        // Swamp Hut configuration
        public final ForgeConfigSpec.IntValue swampHutSpacing;
        public final ForgeConfigSpec.IntValue swampHutSeparation;
        
        // Igloo configuration
        public final ForgeConfigSpec.IntValue iglooSpacing;
        public final ForgeConfigSpec.IntValue iglooSeparation;
        
        // Ocean Monument configuration
        public final ForgeConfigSpec.IntValue oceanMonumentSpacing;
        public final ForgeConfigSpec.IntValue oceanMonumentSeparation;
        
        // Shipwreck configuration
        public final ForgeConfigSpec.IntValue shipwreckSpacing;
        public final ForgeConfigSpec.IntValue shipwreckSeparation;
        
        // Ocean Ruins configuration
        public final ForgeConfigSpec.IntValue oceanRuinsSpacing;
        public final ForgeConfigSpec.IntValue oceanRuinsSeparation;
        
        // Pillager Outpost configuration
        public final ForgeConfigSpec.IntValue pillagerOutpostSpacing;
        public final ForgeConfigSpec.IntValue pillagerOutpostSeparation;
        
        // Mansion configuration
        public final ForgeConfigSpec.IntValue mansionSpacing;
        public final ForgeConfigSpec.IntValue mansionSeparation;
        
        // Nether Fortress configuration
        public final ForgeConfigSpec.IntValue netherFortressSpacing;
        public final ForgeConfigSpec.IntValue netherFortressSeparation;
        
        // End City configuration
        public final ForgeConfigSpec.IntValue endCitySpacing;
        public final ForgeConfigSpec.IntValue endCitySeparation;

        public Common(ForgeConfigSpec.Builder builder) {
            builder.comment("MaxVillage Configuration")
                   .comment("Configure natural structure generation")
                   .push("structures");

            // Village
            builder.comment("Village Generation Settings")
                   .comment("Spacing: Average distance between villages (in chunks)")
                   .comment("Separation: Minimum distance between villages (in chunks)")
                   .push("village");
            villageSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            villageSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Desert Pyramid
            builder.comment("Desert Pyramid Generation Settings")
                   .push("desert_pyramid");
            desertPyramidSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            desertPyramidSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Jungle Temple
            builder.comment("Jungle Temple Generation Settings")
                   .push("jungle_temple");
            jungleTempleSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            jungleTempleSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Swamp Hut
            builder.comment("Swamp Hut Generation Settings")
                   .push("swamp_hut");
            swampHutSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            swampHutSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Igloo
            builder.comment("Igloo Generation Settings")
                   .push("igloo");
            iglooSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            iglooSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Ocean Monument
            builder.comment("Ocean Monument Generation Settings")
                   .push("ocean_monument");
            oceanMonumentSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            oceanMonumentSeparation = builder
                    .comment("Default: 5")
                    .defineInRange("separation", 5, 1, 1000);
            builder.pop();

            // Shipwreck
            builder.comment("Shipwreck Generation Settings")
                   .push("shipwreck");
            shipwreckSpacing = builder
                    .comment("Default: 24")
                    .defineInRange("spacing", 24, 1, 1000);
            shipwreckSeparation = builder
                    .comment("Default: 4")
                    .defineInRange("separation", 4, 1, 1000);
            builder.pop();

            // Ocean Ruins
            builder.comment("Ocean Ruins Generation Settings")
                   .push("ocean_ruins");
            oceanRuinsSpacing = builder
                    .comment("Default: 20")
                    .defineInRange("spacing", 20, 1, 1000);
            oceanRuinsSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Pillager Outpost
            builder.comment("Pillager Outpost Generation Settings")
                   .push("pillager_outpost");
            pillagerOutpostSpacing = builder
                    .comment("Default: 32")
                    .defineInRange("spacing", 32, 1, 1000);
            pillagerOutpostSeparation = builder
                    .comment("Default: 8")
                    .defineInRange("separation", 8, 1, 1000);
            builder.pop();

            // Mansion
            builder.comment("Woodland Mansion Generation Settings")
                   .push("mansion");
            mansionSpacing = builder
                    .comment("Default: 80")
                    .defineInRange("spacing", 80, 1, 1000);
            mansionSeparation = builder
                    .comment("Default: 20")
                    .defineInRange("separation", 20, 1, 1000);
            builder.pop();

            // Nether Fortress
            builder.comment("Nether Fortress Generation Settings")
                   .push("nether_fortress");
            netherFortressSpacing = builder
                    .comment("Default: 27")
                    .defineInRange("spacing", 27, 1, 1000);
            netherFortressSeparation = builder
                    .comment("Default: 4")
                    .defineInRange("separation", 4, 1, 1000);
            builder.pop();

            // End City
            builder.comment("End City Generation Settings")
                   .push("end_city");
            endCitySpacing = builder
                    .comment("Default: 20")
                    .defineInRange("spacing", 20, 1, 1000);
            endCitySeparation = builder
                    .comment("Default: 11")
                    .defineInRange("separation", 11, 1, 1000);
            builder.pop();

            builder.pop();
        }
    }
}
