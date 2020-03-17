package dev.iamsandy.daggerlearning.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.model.Driver
import javax.inject.Singleton

@Module
class DriverModule {

    @Provides
    @Singleton
    fun provideDriver(): Driver {
        return Driver()
    }
}