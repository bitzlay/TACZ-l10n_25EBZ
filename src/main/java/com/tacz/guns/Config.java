package com.tacz.guns;

import com.starspath.justwalls.JustWalls;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.Arrays;
import java.util.List;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = GunMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue MATERIAL_PER_BLOCK;
    public static final ForgeConfigSpec.IntValue DESTRUCTION_MODE;
    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> DESTRUCTION_WHITELIST;
    public static final ForgeConfigSpec.IntValue MATERIAL_REPAIR;
    public static final ForgeConfigSpec.DoubleValue REPAIR_PERCENTAGE;
    public static final ForgeConfigSpec.IntValue REPAIR_AMOUNT;

    public static final ForgeConfigSpec.DoubleValue THATCH_RESISTANCE;
    public static final ForgeConfigSpec.DoubleValue WOODEN_RESISTANCE;
    public static final ForgeConfigSpec.DoubleValue STONE_RESISTANCE;
    public static final ForgeConfigSpec.DoubleValue METAL_RESISTANCE;
    public static final ForgeConfigSpec.DoubleValue ARMORED_RESISTANCE;


    static {
        BUILDER.push("Hammer Config");
        MATERIAL_PER_BLOCK = BUILDER
                .comment("Amount of material to build or upgrade a tile per block; total material = number of block x this value (default 2)")
                .defineInRange("materialPerBlock", 2, 1, 7);
        MATERIAL_REPAIR = BUILDER
                .comment("Amount of material required to repair a structure")
                .defineInRange("materialRepair", 1, 0, 255);
        REPAIR_PERCENTAGE = BUILDER
                .comment("Percentage of Max HP that would be restored to structure when repairing (default 0.2)")
                .defineInRange("repairPercentage", 0.2, 0, 1);
        REPAIR_AMOUNT = BUILDER
                .comment("Amount of HP that would be restored to a structure when repairing. This is added after repairPercentage (default 0)")
                .defineInRange("repairAmount", 0, 0, Integer.MAX_VALUE);
        DESTRUCTION_MODE = BUILDER
                .comment("Structure Block destruction integration with TACZ mod. 0 - no destruction, 1 - all structure blocks from justwalls, 2 - whitelist, 3 - all blocks")
                .defineInRange("mode", 1, 0, 3);
        DESTRUCTION_WHITELIST = BUILDER
                .comment("whitelist for blocks that can be destroyed by TACZ")
                .defineList("whitelist", Arrays.asList("minecraft:stone"), entry -> true);
        BUILDER.pop();

        BUILDER.push("Tiers");
        THATCH_RESISTANCE = BUILDER
                .comment("Amount of HP multiplier structures with this tier have x100 (default 3 = 300hp)")
                .defineInRange("thatchResistance", 3, 1, 1000d);
        WOODEN_RESISTANCE = BUILDER
                .comment("Amount of HP multiplier structures with this tier have x100 (default 5 = 500hp)")
                .defineInRange("woodenResistance", 5, 1, 1000d);
        STONE_RESISTANCE = BUILDER
                .comment("Amount of HP multiplier structures with this tier have x100 (default 7.5 = 750hp)")
                .defineInRange("stoneResistance", 7.5, 1, 1000d);
        METAL_RESISTANCE = BUILDER
                .comment("Amount of HP multiplier structures with this tier have x100 (default 10 = 1000hp)")
                .defineInRange("metalResistance", 10, 1, 1000d);
        ARMORED_RESISTANCE = BUILDER
                .comment("Amount of HP multiplier structures with this tier have x100 (default 12.5 = 1250hp)")
                .defineInRange("armoredResistance", 12.5, 1, 1000d);
        BUILDER.pop();


        SPEC = BUILDER.build();
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

    }
}
