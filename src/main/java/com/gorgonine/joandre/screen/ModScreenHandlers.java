package com.gorgonine.joandre.screen;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.screen.custom.YogurtMachineScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<YogurtMachineScreenHandler> YOGURT_MACHINE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Joandre.MOD_ID, "yogurt_screen_handler"), new ExtendedScreenHandlerType<>(YogurtMachineScreenHandler::new, BlockPos.PACKET_CODEC));



}
