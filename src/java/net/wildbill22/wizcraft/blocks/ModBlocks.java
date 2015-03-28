package net.wildbill22.wizcraft.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wildbill22.wizcraft.Creative_Tab;
import net.wildbill22.wizcraft.lib.Reference;

public class ModBlocks extends Block {
 	public static Block quidditchChest;
 	public static Block blockGoal;
	
	public static void preInit() {
			
		quidditchChest = new BlockQuidditchChest();
		blockGoal = new BlockGoal().setBlockName(BlockGoal.name).setCreativeTab(Creative_Tab.TabWizcraft);
				
		GameRegistry.registerBlock(quidditchChest, BlockQuidditchChest.name);
		GameRegistry.registerBlock(blockGoal, BlockGoal.name);
	}

	public static void init() {
//		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(goldCoin), 1, 3, 50));
	}

	/**
	 * Makes a block and sets most of its properties
	 * @param unlocalizedname
	 * @param texturename
	 * @param material
	 */
	public ModBlocks(String unlocalizedname, String texturename, Material material){
		super(material);
		
		setBlockName(unlocalizedname);
		setBlockTextureName(Reference.MODID + ":" + unlocalizedname);
		setCreativeTab(Creative_Tab.TabWizcraft);
	}
}
