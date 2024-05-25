package at.ridgo8.moreoverlays.config;

// import net.neoforged.common.ForgeConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    public static ModConfigSpec config_client;

    public static ModConfigSpec.IntValue light_UpRange;
    public static ModConfigSpec.IntValue light_DownRange;
    public static ModConfigSpec.IntValue light_HRange;
    public static ModConfigSpec.BooleanValue light_IgnoreLayer;
    public static ModConfigSpec.BooleanValue light_IgnoreSpawnList;
    public static ModConfigSpec.BooleanValue light_SimpleEntityCheck;
    public static ModConfigSpec.IntValue light_SaveLevel;
    public static ModConfigSpec.BooleanValue light_FinishedMigration;

    public static ModConfigSpec.IntValue chunk_EdgeRadius;
    public static ModConfigSpec.BooleanValue chunk_ShowMiddle;

    public static ModConfigSpec.IntValue render_chunkEdgeColor;
    public static ModConfigSpec.IntValue render_chunkGridColor;
    public static ModConfigSpec.IntValue render_chunkMiddleColor;
    public static ModConfigSpec.DoubleValue render_chunkLineWidth;
    public static ModConfigSpec.IntValue render_spawnAColor;
    public static ModConfigSpec.IntValue render_spawnNColor;
    public static ModConfigSpec.DoubleValue render_spawnLineWidth;

    public static ModConfigSpec.BooleanValue search_enabled;
    public static ModConfigSpec.BooleanValue search_searchCustom;
    public static ModConfigSpec.IntValue search_searchBoxColor;
    public static ModConfigSpec.IntValue search_filteredSlotColor;
    public static ModConfigSpec.DoubleValue search_filteredSlotTransparancy;


    public static void initialize() {
        final ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("Settings for the light / mobspawn overlay").push("lightoverlay");
        light_UpRange = builder.comment("Range of the lightoverlay (positive Y)").defineInRange("uprange", 4, 0, Integer.MAX_VALUE);
        light_DownRange = builder.comment("Range of the lightoverlay (negative Y)").defineInRange("downrange", 16, 0, Integer.MAX_VALUE);
        light_HRange = builder.comment("Range of the lightoverlay (Horizontal N,E,S,W)").defineInRange("hrange", 16, 0, Integer.MAX_VALUE);
        light_IgnoreLayer = builder.comment("Ignore if there in no 2 Block space to spawn. (Less lag if true)").define("ignoreLayer", false);
        light_IgnoreSpawnList = builder.comment("Ignore if mobs can actually spawn according to other mods and biome spawn lists and just go by light value").define("ignoreSpawnList", false);
        light_SimpleEntityCheck = builder.comment("Blocks can allow/disallow spawns for different entity types. The check for this isn't very performat.\nSetting this to true will increase performance but decrease accuracy.").define("simpleCheck", false);
        light_SaveLevel = builder.comment("Minimum save light level where no mobs can spawn").defineInRange("saveLevel", 1, 0, Integer.MAX_VALUE);
        light_FinishedMigration = builder.comment("Finished 1.18 migration (don't change)").define("finishedMigration", false);
        builder.pop();

        builder.comment("Settings for the chunk bounds overlay").push("chunkbounds");
        chunk_EdgeRadius = builder.comment("Radius (in Chunks) to show the edges (red line)").defineInRange("radius", 1, 0, Integer.MAX_VALUE);
        chunk_ShowMiddle = builder.comment("Show the middle of the current Chunk (yellow line)").define("middle", true);
        builder.pop();

        builder.comment("General render settings.\nLine thickness, Colors, ...").push("rendersettings");
        render_chunkEdgeColor = builder.comment("Color for the chunk edge").defineInRange("chunk_edge_color", 0xFF0000, 0, 0xFFFFFF);
        render_chunkGridColor = builder.comment("Color for the chunk grid").defineInRange("chunk_grid_color", 0x00FF00, 0, 0xFFFFFF);
        render_chunkMiddleColor = builder.comment("Color for the middle chunk line").defineInRange("chunk_mid_color", 0xFFFF00, 0, 0xFFFFFF);
        render_chunkLineWidth = builder.comment("Line width for chunk boundaries").defineInRange("chunk_line_width", 1.5, 0, Double.MAX_VALUE);
        render_spawnAColor = builder.comment("Color the X that marks \"Spawns always possible\"").defineInRange("spawn_always_color", 0xFF0000, 0, 0xFFFFFF);
        render_spawnNColor = builder.comment("Color the X that marks \"Spawns at night possible\"").defineInRange("spawn_night_color", 0xFFFF00, 0, 0xFFFFFF);
        render_spawnLineWidth = builder.comment("Line width for spawn indication").defineInRange("spawn_line_width", 2, 0, Double.MAX_VALUE);
        builder.pop();

        builder.comment("Settings for the search overlay").push("searchoverlay");
        search_enabled = builder.comment("Setting this to false this will disable the functionality to double click the JEI search bar for item searching.").define("search_enabled", true);
        search_searchCustom = builder.comment("Also searches for the custom name of an item in user inventory (for example items named in anvil)\nSetting this to false will increase performance but will not find custom named items.").define("custom_search", true);
        search_searchBoxColor = builder.comment("Color for the search box when double clicked").defineInRange("search_box_color", 0xFFFF00, 0, 0xFFFFFF);
        search_filteredSlotColor = builder.comment("Color of the filtered out slots").defineInRange("search_slot_color", 0x000000, 0, 0xFFFFFF);
        search_filteredSlotTransparancy = builder.comment("Transparancy for the filtered out slots").defineInRange("search_slot_alpha", 0.5F, 0F, 1F);
        builder.pop();

        config_client = builder.build();
    }

	/*public static void getCategories(List<String> list) {
		list.add("lightoverlay");
		list.add("chunkbounds");
		//list.add("itemsearch");
		list.add("rendersettings");
	}*/
}
