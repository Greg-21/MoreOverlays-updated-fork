package at.feldim2425.moreoverlays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//@Mod(modid = MoreOverlays.MOD_ID, updateJSON = MoreOverlays.UPDATE_JSON, version = MoreOverlays.VERSION, name = MoreOverlays.NAME, clientSideOnly = true, dependencies = "required-after:forge@[14.23.5.2768,);after:jei@[4.15.0.268,);", guiFactory = "at.feldim2425.moreoverlays.config.GuiFactory")
@Mod(MoreOverlays.MOD_ID)
public class MoreOverlays {

	public static final String MOD_ID = "moreoverlays";
	public static final String NAME = "MoreOverlays";
	//public static final String VERSION = "1.15.1";
	//public static final String UPDATE_JSON = "https://raw.githubusercontent.com/feldim2425/Mod_Update-JSONs/master/MoreOverlays.json";

	public static Logger logger = LogManager.getLogger(NAME);

	public MoreOverlays(){
		final IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
		final ModLoadingContext ctx = ModLoadingContext.get();

		modBus.addListener(this::preInit);

	}

	public void preInit(FMLClientSetupEvent event) {
		//ConfigHandler.init(event);
	}
}
