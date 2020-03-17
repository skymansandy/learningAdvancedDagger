package dev.iamsandy.playdump.di.component

import dagger.Component
import dev.iamsandy.playdump.di.module.DriverModule
import dev.iamsandy.playdump.model.Driver
import javax.inject.Singleton

@Singleton
@Component(modules = [DriverModule::class])
interface AppComponent {

    fun getDriver(): Driver
}