package net.wildbill22.wizcraft.proxies;

import net.wildbill22.wizcraft.client.renderer.*;
import net.wildbill22.wizcraft.entity.*;
import net.wildbill22.wizcraft.lib.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

/** 
 * @author WILLIAM
 *
 */
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderer(){
		//Entities, the 0.5F is the shadow size
		RenderingRegistry.registerEntityRenderingHandler(EntityBludger.class, new RenderBludger());
		RenderingRegistry.registerEntityRenderingHandler(EntityBroom.class, new RenderBroom());
		RenderingRegistry.registerEntityRenderingHandler(EntityQuaffle.class, new RenderQuaffle());
		RenderingRegistry.registerEntityRenderingHandler(EntitySnitch.class, new RenderSnitch());
		
		// Throwable entities
//		RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new RenderSpear(ModItems.spear));
		
		//Items
//		MinecraftForgeClient.registerItemRenderer(ModWeapons.longBow, new BowRender());
	}
	
	@Override
	public void registerTileEntitySpecialRenderer(){		
	}

	@Override
	public void registerSounds() {}
	
	@Override
	public void registerSubscriptions() {
		super.registerSubscriptions();
		LogHelper.info("ClientProxy: Registering subscriptions");
//		MinecraftForge.EVENT_BUS.register(new DragonHudOverlay(Minecraft.getMinecraft()));
	}
}
