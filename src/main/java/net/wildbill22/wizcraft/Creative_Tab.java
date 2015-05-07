package net.wildbill22.wizcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class Creative_Tab {

	public static CreativeTabs TabWizcraft = new CreativeTabs("Wizcraft"){@Override public Item getTabIconItem() {return Item.getItemFromBlock (Blocks.dragon_egg);}};
	public static void OtherInfo() {
		
	}

}
