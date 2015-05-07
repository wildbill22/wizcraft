package net.wildbill22.wizcraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.lib.Reference;

public class ItemHeadband extends ItemArmor {
	private String textureName;
	private int renderIndex;
	
	public ItemHeadband(int headBandType, String unlocalizedName, ArmorMaterial material, String textureName, int type) {
	    super(material, 0, type);
	    renderIndex = headBandType;
	    this.textureName = textureName;
	    this.setUnlocalizedName(unlocalizedName);
	    this.setTextureName(Reference.MODID + ":" + unlocalizedName);
	}
	
	public int headBandType() {
		return renderIndex;
	}
//	protected ItemHeadband(){
//		super(i, EnumArmorMaterial.DIAMOND, t, 0);
//		maxStackSize=1;
//		//damageReduceAmount=100;
//		setMaxDamage(1000000);
//	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer){
		//itemstack.stackSize--;
		if(!world.isRemote){
			if (renderIndex == ((ItemHeadband)ModItems.headband).headBandType())
				itemstack = (new ItemStack(ModItems.headbandKeeper, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyRed, 1));
			else if(renderIndex == ((ItemHeadband)ModItems.headbandKeeper).headBandType())
				itemstack = (new ItemStack(ModItems.headbandSeeker, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyOrange, 1));
			else if(renderIndex == ((ItemHeadband)ModItems.headbandSeeker).headBandType())
				itemstack = (new ItemStack(ModItems.headbandChaser, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyYellow, 1));
			else if(renderIndex == ((ItemHeadband)ModItems.headbandChaser).headBandType())
				itemstack = (new ItemStack(ModItems.headbandBeater, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.JerseyGreen, 1));
			else
				itemstack = (new ItemStack(ModItems.headband, 1));
				//entityplayer.inventory.addItemStackToInventory(new ItemStack(mod_QuidditchSMP.Jersey, 1));
		}
		return itemstack;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	    return Reference.MODID + ":textures/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}