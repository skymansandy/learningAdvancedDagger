package dev.iamsandy.daggerlearning.di.component

import dagger.Component
import dev.iamsandy.daggerlearning.di.module.DriverModule
import dev.iamsandy.daggerlearning.model.Driver
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {

    fun getDriver(): Driver
}