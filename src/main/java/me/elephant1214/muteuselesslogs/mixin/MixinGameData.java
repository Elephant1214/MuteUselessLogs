package me.elephant1214.muteuselesslogs.mixin;

import net.minecraftforge.registries.GameData;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameData.class)
public class MixinGameData {
    @Redirect(
            method = "checkPrefix(Ljava/lang/String;Z)Lnet/minecraft/util/ResourceLocation;",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V",
                    remap = false
            ),
            remap = false
    )
    private static void noPotentiallyDangerousWarns(Logger instance, String s, Object o, Object o1, Object o2) {
    }
}
