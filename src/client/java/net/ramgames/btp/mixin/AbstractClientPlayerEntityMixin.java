package net.ramgames.btp.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.ramgames.btp.BeyondThePastClient;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public abstract class AbstractClientPlayerEntityMixin extends PlayerEntity {


    @Shadow @Nullable protected abstract PlayerListEntry getPlayerListEntry();

    public AbstractClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "getSkinTextures", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/network/PlayerListEntry;getSkinTextures()Lnet/minecraft/client/util/SkinTextures;"), cancellable = true)
    public void changePlayerCape(CallbackInfoReturnable<SkinTextures> cir) {
        if(!this.uuid.toString().equals("e16d995e-d277-4ff6-80bc-bf176d606404")) return;
        PlayerListEntry playerListEntry = this.getPlayerListEntry();
        if(playerListEntry == null) return;
        SkinTextures textures = playerListEntry.getSkinTextures();
        if(textures.capeTexture() != null) BeyondThePastClient.LOGGER.info("cape texture: "+textures.capeTexture().getPath());
        cir.setReturnValue(new SkinTextures(
                textures.texture(),
                textures.textureUrl(),
                new Identifier("btp:textures/capes/team_cape.png"),
                textures.elytraTexture(),
                textures.model(),
                textures.secure()
        ));
    }
}
