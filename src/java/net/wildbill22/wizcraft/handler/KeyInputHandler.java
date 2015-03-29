package net.wildbill22.wizcraft.handler;

import net.wildbill22.wizcraft.lib.KeyBindings;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.broomDown.isPressed())
            System.out.println("broom up");
        if (KeyBindings.broomUp.isPressed())
            System.out.println("broom down");
    }

}
