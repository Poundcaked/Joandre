package com.gorgonine.joandre.screen;

import com.gorgonine.joandre.Joandre;
import com.gorgonine.joandre.screen.custom.YogurtMachineScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class YogurtMachineScreen extends HandledScreen<YogurtMachineScreenHandler> {
    public static final Identifier GUI_TEXTURE =
            Identifier.of(Joandre.MOD_ID, "textures/gui/yogurt_machine/yogurt_machine_gui.png");

    public YogurtMachineScreen(YogurtMachineScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(
                RenderLayer::getGuiTextured, //render layers (or render type callback)
                YogurtMachineScreen.GUI_TEXTURE, // texture Identifier
                x, //x
                y, //y
                0, // can't figure what is this param
                0, // can't figure what is this param
                this.backgroundWidth, // background width
                this.backgroundHeight, // background height
                256, // image width
                256 // image height
        );
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
