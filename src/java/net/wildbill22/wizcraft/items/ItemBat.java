package net.wildbill22.wizcraft.items;

public class ItemBat extends ModItems {
	public static final String name = "bat";
	
	protected ItemBat(){
		super(name, name);
//		maxStackSize=1;	
	}
	/*public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l){
		itemstack.stackSize--;
		return true;
	}*/
}
