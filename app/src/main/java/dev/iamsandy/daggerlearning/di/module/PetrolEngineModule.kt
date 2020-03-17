package dev.iamsandy.daggerlearning.di.module

import dagger.Binds
import dagger.Module
import dev.iamsandy.daggerlearning.model.Engine
import dev.iamsandy.daggerlearning.model.PetrolEngine

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun providePetrolEngine(petrolEngine: PetrolEngine): Engine
}