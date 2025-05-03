package com.github.cao.awa.medical.nbt

import net.minecraft.nbt.NbtCompound

abstract class NbtObject {
    abstract fun readNbt(compound: NbtCompound)
    abstract fun writeNbt(key: String, compound: NbtCompound)
}