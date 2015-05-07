package net.wildbill22.wizcraft.proxies;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import net.wildbill22.wizcraft.lib.LogHelper;

/**
 * 
 * @author WILLIAM
 *
 */
public class CommonProxy { 
	public void registerRenderer(){}
	
	public void registerTileEntitySpecialRenderer(){}
	
	public void registerSounds() {}
	
	public void registerSubscriptions() {
		LogHelper.info("CommonProxy: Registering subscriptions");
	}
}
