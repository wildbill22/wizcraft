package net.wildbill22.wizcraft;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.wildbill22.wizcraft.blocks.ModBlocks;
import net.wildbill22.wizcraft.items.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModCraftingRecipes {
	public static void init() {

		GameRegistry.addShapedRecipe(new ItemStack(ModItems.quaffle, 1), 
				" L ",
				"L L",
				" L ",
				'L', Items.leather);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.bludger, 1), 
				" I ",
				"IBI",
				" I ",
				'I', Items.iron_ingot, 'B', Items.bone);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.snitch, 1), 
				"   ",
				"FGF",
				"   ",
				'F', Items.feather, 'G', Items.gold_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.bat, 1), 
				"  P",
				" P ",
				"S  ",
				'S', Items.stick, 'P', Blocks.planks);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.broom, 1), 
				"  S",
				" S ",
				"W  ",
				'S', Items.stick, 'P', Items.wheat);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.bludgerGlove, 1), 
				"   ",
				"I I",
				"   ",
				'I', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.snitchGlove, 1), 
				"   ",
				"L L",
				"  ",
				'L', Items.leather);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockGoal, 1), 
				"C C",
				" C ",
				"C C",
				'C', Blocks.carpet);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.quidditchChest, 1), 
				" Q ",
				"BCB",
				" S ",
				'Q', ModItems.quaffle, 'B', ModItems.bludger, 'C', Blocks.chest, 'S', ModItems.snitch);
	}	
}
