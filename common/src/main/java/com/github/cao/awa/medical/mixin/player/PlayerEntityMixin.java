package com.github.cao.awa.medical.mixin.player;

import com.github.cao.awa.medical.disease.immunity.ImmunitySystem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Unique
    private final ImmunitySystem immunitySystem = new ImmunitySystem();

    @Inject(
            method = "readCustomDataFromNbt",
            at = @At("RETURN")
    )
    public void readImmunity(NbtCompound nbt, CallbackInfo ci) {
        this.immunitySystem.readNbt(nbt.getCompoundOrEmpty("ImmunitySystem"));
    }

    @Inject(
            method = "writeCustomDataToNbt",
            at = @At("RETURN")
    )
    public void writeImmunity(NbtCompound nbt, CallbackInfo ci) {
        this.immunitySystem.writeNbt("ImmunitySystem", nbt);
    }
}
