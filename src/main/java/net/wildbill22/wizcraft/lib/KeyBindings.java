package net.wildbill22.wizcraft.lib;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

public class KeyBindings {
    public static KeyBinding broomUp;
    public static KeyBinding broomDown;
    
	public static void preInit() {
        // Define the "broomUp" binding, with (unlocalized) name "key.broomUp" and
        // the category with (unlocalized) name "key.categories.wizcraft"
		broomUp = new KeyBinding("key.broomUp", Keyboard.KEY_C, "key.categories.movement");
        // Define the "broomDown" binding, with (unlocalized) name "key.broomDown" and
        // the category with (unlocalized) name "key.categories.wizcraft"
		broomDown = new KeyBinding("key.broomDown", Keyboard.KEY_V, "key.categories.movement");

        // Register both KeyBindings to the ClientRegistry
        ClientRegistry.registerKeyBinding(broomUp);
        ClientRegistry.registerKeyBinding(broomDown);
	}
}
