package dev.iamsandy.daggerlearning

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dev.iamsandy.daggerlearning.di.app.DaggerAppComponent

class PlayDumpApp : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}