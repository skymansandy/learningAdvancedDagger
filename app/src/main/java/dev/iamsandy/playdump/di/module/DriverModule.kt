package dev.iamsandy.playdump.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.playdump.model.Driver
import javax.inject.Singleton

@Module
class DriverModule {

    @Provides
    @Singleton
    fun provideDriver(): Driver {
        return Driver()
    }
}