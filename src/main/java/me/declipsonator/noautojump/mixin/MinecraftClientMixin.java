package me.declipsonator.noautojump.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.option.GameOptions;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Final
    @Shadow
    public GameOptions options;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInit(RunArgs args, CallbackInfo ci) {
        options.autoJump = false;
    }
}
