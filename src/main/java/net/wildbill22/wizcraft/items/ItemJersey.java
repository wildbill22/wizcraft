package net.wildbill22.wizcraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.lib.Reference;

public class ItemJersey extends ItemArmor {
	private String textureName;
	private int renderIndex;
	public int bludgerDamage;
	
	public ItemJersey(int jerseyType, String unlocalizedName, ArmorMaterial material, String textureName, int type) {
	    super(material, 0, type);
	    renderIndex = jerseyType;
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(Reference.MODID + ":" + unlocalizedName);
	}
	
//	protected ItemJersey(int i,int t){
//		super(i, EnumArmorMaterial.DIAMOND, t, 1);
//		maxStackSize=1;
//		setMaxDamage(1000000);
//	}
	
	public int jerseyType() {
		return renderIndex;
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		//itemstack.stackSize--;
		if(!world.isRemote){
			if(renderIndex == ((ItemJersey)ModItems.jerseyRed).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyRed, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyRed, 1));
			else if(renderIndex == ((ItemJersey)ModItems.jerseyRed).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyOrange, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyOrange, 1));
			else if(renderIndex == ((ItemJersey)ModItems.jerseyOrange).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyYellow, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyYellow, 1));
			else if(renderIndex == ((ItemJersey)ModItems.jerseyYellow).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyGreen, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyGreen, 1));
			else if(renderIndex == ((ItemJersey)ModItems.jerseyGreen).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyBlue, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyBlue, 1));
			else if(renderIndex == ((ItemJersey)ModItems.jerseyBlue).jerseyType())
				itemstack = (new ItemStack(ModItems.jerseyPurple, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyPurple, 1));
			else
				itemstack = (new ItemStack(ModItems.jersey, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.Jersey, 1));
		}
		return itemstack;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	    return Reference.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}
