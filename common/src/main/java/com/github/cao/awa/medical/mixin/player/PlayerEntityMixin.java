package com.github.cao.awa.medical.mixin.player;

import com.github.cao.awa.medical.api.MedicalDelegate;
import com.github.cao.awa.medical.api.immunity.ImmunityDelegate;
import com.github.cao.awa.medical.disease.immunity.ImmunitySystem;
import com.github.cao.awa.medical.disease.immunity.infection.type.InfectionType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
abstract public class PlayerEntityMixin extends Entity implements MedicalDelegate {
    @Unique
    private final ImmunitySystem immunitySystem = new ImmunitySystem(this);

    public PlayerEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    private PlayerEntity bePlayerEntity() {
        return (PlayerEntity) (Object) this;
    }

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

    @Inject(
            method = "tick",
            at  = @At("RETURN")
    )
    public void randomInfection(CallbackInfo ci) {
        if (getWorld().isClient) {
            return;
        }

        Random random = getWorld().random;

        if (random.nextBoolean()) {
            InfectionType infectionType = InfectionType.get(random);

            this.immunitySystem.infection(
                    infectionType,
                    bePlayerEntity()
            );
        }
    }
}
