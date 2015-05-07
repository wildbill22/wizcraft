package net.wildbill22.wizcraft;

import net.minecraftforge.common.MinecraftForge;
import net.wildbill22.wizcraft.blocks.ModBlocks;
import net.wildbill22.wizcraft.entity.ModEntities;
import net.wildbill22.wizcraft.handler.KeyInputHandler;
// import net.wildbill22.wizcraft.crafting.ModCraftingRecipes;
import net.wildbill22.wizcraft.items.ModItems;
import net.wildbill22.wizcraft.lib.KeyBindings;
import net.wildbill22.wizcraft.lib.LogHelper;
import net.wildbill22.wizcraft.lib.Reference;
import net.wildbill22.wizcraft.proxies.CommonProxy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
	
/** 
 * @author WILLIAM
 *
 */
//@Mod(modid = REFERENCE.MODID, name = REFERENCE.NAME, version = REFERENCE.VERSION, guiFactory = "net.wildbill22.draco.client.gui.ModGuiFactory")
@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)

public class WizcraftMod {

	@SidedProxy(clientSide = "net.wildbill22.wizcraft.proxies.ClientProxy", serverSide = "net.wildbill22.wizcraft.proxies.CommonProxy")
	public static CommonProxy wizcraftProxy;

	public static SimpleNetworkWrapper modChannel;

	@Instance(Reference.MODID)
	public static WizcraftMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
//		Configs.init(event.getSuggestedConfigurationFile());// Keep first
		Creative_Tab.OtherInfo();
		ModItems.preInit();
		ModBlocks.preInit();
//    		ModTileEntities.modRegistry();
		ModEntities.preInit();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		KeyBindings.preInit();
//		ModWeapons.preInit();
		wizcraftProxy.registerRenderer();
//		VillageBiomes.preInit(event);
//		setupNetwork();
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		ModCraftingRecipes.init();		
//		ModWeapons.init();
//		GameRegistry.registerWorldGenerator(new WorldGenDracoAnimus(), 100);
		KeyBindings.preInit();
		wizcraftProxy.registerSounds();
		wizcraftProxy.registerSubscriptions();
//		FMLCommonHandler.instance().bus().register(new Configs());
//		if (Configs.VILLAGE.village_gen_enabled) {
//			LogHelper.info("Registering replacer for village generation.");
//			MinecraftForge.TERRAIN_GEN_BUS.register(new VillageGenReplacer());
//		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
//		VillageBiomes.postInit(event);
	}
	
	// For future use:
	private void setupNetwork() {
		modChannel = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);

		int id = 0;
//		modChannel.registerMessage(UpdateDragonPlayerPacket.Handler.class, UpdateDragonPlayerPacket.class, id++, Side.SERVER);
	}
}
