package net.wildbill22.wizcraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.entity.EntitySnitch;

public class ItemSnitch extends ModItems {
	public static final String name = "snitch";

	public ItemSnitch() {
		super(name, name);
		maxStackSize=1;	
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        itemstack.stackSize--;
        //world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if(!world.isRemote)
        {
            world.spawnEntityInWorld(new EntitySnitch(world, entityplayer));
        }
        return itemstack;
    }
}
