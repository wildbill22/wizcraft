package net.wildbill22.wizcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSnitchGlove extends ModItems {
	public static final String name = "snitchGlove";
	
	protected ItemSnitchGlove(){
		super(name, name);
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l){
		return true;
	}
}
