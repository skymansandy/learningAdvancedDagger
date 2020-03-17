package dev.iamsandy.playdump.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.playdump.model.Rims
import dev.iamsandy.playdump.model.Tyres
import dev.iamsandy.playdump.model.Wheels

@Module
class WheelModule {

    @Provides
    fun provideRims(): Rims {
        return Rims()
    }

    @Provides
    fun provideTyres(): Tyres {
        return Tyres()
    }

    @Provides
    fun provideWheels(rims: Rims, tyres: Tyres): Wheels {
        return Wheels(rims, tyres)
    }
}