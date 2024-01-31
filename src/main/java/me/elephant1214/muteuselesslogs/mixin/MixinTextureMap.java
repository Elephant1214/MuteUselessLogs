package me.elephant1214.muteuselesslogs.mixin;

import net.minecraft.client.renderer.texture.TextureMap;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = TextureMap.class, priority = 500)
public class MixinTextureMap {
    @Redirect(
            method = "*",
            at = @At(
                    value = "INVOKE",
                    target = "Lorg/apache/logging/log4j/Logger;error(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V",
                    remap = false
            ),
            require = 0
    )
    private void noTexMapErrorSpam(Logger instance, String message, Object p0, Object p1) {
    }
}
