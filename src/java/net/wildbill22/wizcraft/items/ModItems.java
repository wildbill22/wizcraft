package net.wildbill22.wizcraft.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
	// Armor
	public static ArmorMaterial headBandMaterial;
	public static ArmorMaterial jerseyMaterial;
	public static Item headband;
	public static Item headbandKeeper;
	public static Item headbandSeeker;
	public static Item headbandChaser;
	public static Item headbandBeater;
	public static Item jersey;
	public static Item jerseyYellow;
	public static Item jerseyBlue;
	public static Item jerseyRed;
	public static Item jerseyGreen;
	public static Item jerseyOrange;
	public static Item jerseyPurple;
	
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


		// Jersey and headbands
		// name, durability (same as leather), damageReduction, enchantability
		jerseyMaterial = EnumHelper.addArmorMaterial("jerseyMaterial", 5, new int[] { 1, 3, 2, 1 }, 15);		
		GameRegistry.registerItem(jersey = new ItemHeadband(0, "jersey", jerseyMaterial, "jersey", 0), "jersey");
		GameRegistry.registerItem(jerseyYellow = new ItemHeadband(0, "jerseyYellow", jerseyMaterial, "jerseyYellow", 0), "jerseyYellow");
		GameRegistry.registerItem(jerseyBlue = new ItemHeadband(0, "jerseyBlue", jerseyMaterial, "jerseyBlue", 0), "jerseyBlue");
		GameRegistry.registerItem(jerseyRed = new ItemHeadband(0, "jerseyRed", jerseyMaterial, "jerseyRed", 0), "jerseyRed");
		GameRegistry.registerItem(jerseyGreen = new ItemHeadband(0, "jerseyGreenn", jerseyMaterial, "jerseyGreen", 0), "jerseyGreen");
		GameRegistry.registerItem(jerseyOrange = new ItemHeadband(0, "jerseyOrange", jerseyMaterial, "jerseyOrange", 0), "jerseyOrange");
		GameRegistry.registerItem(jerseyPurple = new ItemHeadband(0, "jerseyPurple", jerseyMaterial, "jerseyPurple", 0), "jerseyPurple");
		
		// name, durability (same as leather), damageReduction, enchantability
		headBandMaterial = EnumHelper.addArmorMaterial("headBandMaterial", 5, new int[] { 1, 3, 2, 1 }, 15);		
		GameRegistry.registerItem(headband = new ItemHeadband(0, "headband", headBandMaterial, "headband", 0), "headband");
		GameRegistry.registerItem(headbandKeeper = new ItemHeadband(1, "headbandKeeper", headBandMaterial, "headbandKeeper", 0), "headbandKeeper");
		GameRegistry.registerItem(headbandSeeker = new ItemHeadband(2, "headbandSeeker", headBandMaterial, "headbandSeeker", 0), "headbandSeeker");
		GameRegistry.registerItem(headbandChaser = new ItemHeadband(3, "headbandChaser", headBandMaterial, "headbandChaser", 0), "headbandChaser");
		GameRegistry.registerItem(headbandBeater = new ItemHeadband(4, "headbandBeater", headBandMaterial, "headbandBeater", 0), "headbandBeater");
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
