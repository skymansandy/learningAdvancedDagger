package dev.iamsandy.playdump.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.playdump.di.scope.PerActivity
import dev.iamsandy.playdump.model.DieselEngine
import dev.iamsandy.playdump.model.Engine
import javax.inject.Named

@Module
class DieselEngineModule {

    @Provides
    fun provideDieselEngine(dieselEngine: DieselEngine): Engine {
        return dieselEngine
    }
}