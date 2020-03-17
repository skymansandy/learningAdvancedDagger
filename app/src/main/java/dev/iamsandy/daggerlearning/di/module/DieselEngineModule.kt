package dev.iamsandy.daggerlearning.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.model.DieselEngine
import dev.iamsandy.daggerlearning.model.Engine

@Module
class DieselEngineModule {

    @Provides
    fun provideDieselEngine(dieselEngine: DieselEngine): Engine {
        return dieselEngine
    }
}