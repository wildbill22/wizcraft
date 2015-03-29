package net.wildbill22.wizcraft.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.wildbill22.wizcraft.Creative_Tab;
import net.wildbill22.wizcraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems extends Item {
	//Tool Materials
//	static ToolMaterial SPEAR = EnumHelper.addToolMaterial("SPEAR", 3, 500, 9.5F, 3.0F, 10);

	// All items in the mod:
	public static Item quaffle;
	public static Item snitch;
	public static Item snitchGlove;
	public static Item broom;
	public static Item bat;
	public static Item bludgerGlove;
	public static Item bludger;
	
	public static void preInit() {
		quaffle = new ItemQuaffle();
		snitch = new ItemSnitch();
		snitchGlove = new ItemSnitchGlove();
		broom = new ItemBroom();
		bat = new ItemBat();
		bludgerGlove = new ItemBludgerGlove();
		bludger = new ItemBludger();
		
		GameRegistry.registerItem(quaffle, ItemQuaffle.name);
		GameRegistry.registerItem(snitch, ItemSnitch.name);
		GameRegistry.registerItem(snitchGlove, ItemSnitchGlove.name);
		GameRegistry.registerItem(broom, ItemBroom.name);
		GameRegistry.registerItem(bat, ItemBat.name);
		GameRegistry.registerItem(bludgerGlove, ItemBludgerGlove.name);
		GameRegistry.registerItem(bludger, ItemBludger.name);
	}

	public static void init() {
		// Mod items
//		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(goldCoin), 1, 10, BALANCE.CHEST_ITEMS.VILLAGE_BLACKSMITH_GOLD_COINS));
		
		// Other useful stuff		
	}
	
	/**
	 * Makes a item and sets most of its properties
	 * @param unlocalizedname
	 * @param texturename
	 */
	public ModItems(String unlocalizedname, String texturename){
		super();
		
		this.setCreativeTab(net.wildbill22.wizcraft.Creative_Tab.TabWizcraft);
		this.setUnlocalizedName(Reference.Unlocalized_Path + unlocalizedname);
		this.setTextureName(Reference.Texture_Path + texturename);
	}
	
	/**
	 * Makes a item and sets most of its properties
	 * Use this one when you want to use registerIcons
	 * @param unlocalizedname
	 */
	public ModItems(String unlocalizedname) {
		super();		

		this.setCreativeTab(net.wildbill22.wizcraft.Creative_Tab.TabWizcraft);
		this.setUnlocalizedName(Reference.Unlocalized_Path + unlocalizedname);
	}
	
	// IconRegister renamed to IIconRegister
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void registerIcons(IIconRegister iconRegister) {
//		int beginIndex = getUnlocalizedName().indexOf('_');
//		itemIcon = iconRegister.registerIcon(Reference.Texture_Path + getUnlocalizedName().substring(beginIndex + 1).toLowerCase());
//	}
}
