package dev.iamsandy.playdump

import android.app.Application
import dev.iamsandy.playdump.di.component.AppComponent
import dev.iamsandy.playdump.di.component.DaggerAppComponent

class PlayDumpApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}