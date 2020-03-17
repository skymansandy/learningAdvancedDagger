package dev.iamsandy.daggerlearning.di.module

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.model.Rims
import dev.iamsandy.daggerlearning.model.Tyres
import dev.iamsandy.daggerlearning.model.Wheels

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