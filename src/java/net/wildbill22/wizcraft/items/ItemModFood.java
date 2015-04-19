package net.wildbill22.wizcraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.wildbill22.wizcraft.lib.Reference;

/**
 * Use to add food items in ModItems
 * @author Tmm
 */
public class ItemModFood extends ItemFood {
	private PotionEffect[] effects;

	/**
     * Returns ItemModFood for use in GameRegistry.registerItem
     * @param unlocalizedName
     * @param healAmount - typical is 4, which is 4 half-hearts, or 2 hearts
     * @param saturationModifier - 0.6F is what apple uses, satisfies hunger for that amount
     * @param wolvesFavorite - normally false, otherwise true if you want to tame a wolf with this
     * @param PotionEffect - no idea, not normally used
     */
	public ItemModFood(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavorite, PotionEffect... effects) {
	    super(healAmount, saturationModifier, wolvesFavorite);
	    this.setUnlocalizedName(Reference.Unlocalized_Path + unlocalizedName);
	    this.setTextureName(Reference.MODID + ":" + unlocalizedName);
	    this.setCreativeTab(CreativeTabs.tabFood);
	    this.effects = effects;
	}
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	    super.onFoodEaten(stack, world, player);
	        
	    for (int i = 0; i < effects.length; i ++) {
	        if (!world.isRemote && effects[i] != null && effects[i].getPotionID() > 0)
	            player.addPotionEffect(new PotionEffect(this.effects[i].getPotionID(), this.effects[i].getDuration(), this.effects[i].getAmplifier(), this.effects[i].getIsAmbient()));
	    }
	}

}
