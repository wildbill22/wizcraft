package net.wildbill22.wizcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBludgerGlove extends ModItems {
	public static final String name = "bludgerGlove";

	protected ItemBludgerGlove(){
		super(name, name);
//		maxStackSize=1;	
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l){
		//itemstack.stackSize--;
		return true;
	}
}
