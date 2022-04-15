package me.declipsonator.noautojump.mixin;

import net.minecraft.client.gui.screen.option.AccessibilityOptionsScreen;
import net.minecraft.client.option.Option;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(AccessibilityOptionsScreen.class)
public class AccessibilityScreenMixin {
    @Mutable
    @Final
    @Shadow
    private static Option[] OPTIONS = new Option[]{Option.NARRATOR, Option.SUBTITLES, Option.TEXT_BACKGROUND_OPACITY, Option.TEXT_BACKGROUND, Option.CHAT_OPACITY, Option.CHAT_LINE_SPACING, Option.CHAT_DELAY_INSTANT, Option.AUTO_JUMP, Option.SNEAK_TOGGLED, Option.SPRINT_TOGGLED, Option.DISTORTION_EFFECT_SCALE, Option.FOV_EFFECT_SCALE, Option.MONOCHROME_LOGO, Option.HIDE_LIGHTNING_FLASHES};

    @ModifyArg(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/option/SimpleOptionsScreen;<init>(Lnet/minecraft/client/gui/screen/Screen;Lnet/minecraft/client/option/GameOptions;Lnet/minecraft/text/Text;[Lnet/minecraft/client/option/Option;)V"), index = 3)
    private static Option[] init(Option[] options) {
        List<Option> list = new ArrayList<>(Arrays.asList(OPTIONS));
        list.remove(Option.AUTO_JUMP);
        OPTIONS = list.toArray(Option[]::new);

        return OPTIONS;
    }
}
