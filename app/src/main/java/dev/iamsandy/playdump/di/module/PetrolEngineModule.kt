package dev.iamsandy.playdump.di.module

import dagger.Binds
import dagger.Module
import dev.iamsandy.playdump.di.scope.PerActivity
import dev.iamsandy.playdump.model.Engine
import dev.iamsandy.playdump.model.PetrolEngine

@Module
abstract class PetrolEngineModule {

    @Binds
    abstract fun providePetrolEngine(petrolEngine: PetrolEngine): Engine
}