package me.declipsonator.noautojump.mixin;

import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.ControlsOptionsScreen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.screen.option.KeybindsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ControlsOptionsScreen.class)
public class ControlsOptionsScreenMixin extends GameOptionsScreen {
    public ControlsOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
        super(parent, gameOptions, title);
    }

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/option/ControlsOptionsScreen;addDrawableChild(Lnet/minecraft/client/gui/Element;)Lnet/minecraft/client/gui/Element;"))
    private Element removeAutoJump(ControlsOptionsScreen instance, Element element) {
        if (((ClickableWidget) element).getMessage().getString().contains(new TranslatableText("options.autoJump").getString())) {
            return null;
        }
        return this.addDrawableChild((ClickableWidget) element);
    }
}
