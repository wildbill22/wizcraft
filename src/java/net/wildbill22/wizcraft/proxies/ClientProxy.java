package net.wildbill22.wizcraft.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.wildbill22.wizcraft.blocks.ModBlocks;
import net.wildbill22.wizcraft.client.model.ModelQuaffle;
import net.wildbill22.wizcraft.client.renderer.RenderQuaffle;
import net.wildbill22.wizcraft.entity.EntityQuaffle;
import net.wildbill22.wizcraft.items.*;
import net.wildbill22.wizcraft.lib.LogHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
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
		RenderingRegistry.registerEntityRenderingHandler(EntityQuaffle.class, new RenderQuaffle());
		
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
