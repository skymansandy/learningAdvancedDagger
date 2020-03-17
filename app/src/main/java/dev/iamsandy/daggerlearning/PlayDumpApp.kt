package dev.iamsandy.daggerlearning

import android.app.Application
import dev.iamsandy.daggerlearning.di.component.AppComponent
import dev.iamsandy.daggerlearning.di.component.DaggerAppComponent

class PlayDumpApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}