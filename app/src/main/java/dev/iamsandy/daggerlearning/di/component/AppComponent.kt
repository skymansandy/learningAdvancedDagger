package dev.iamsandy.daggerlearning.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.iamsandy.daggerlearning.PlayDumpApp
import dev.iamsandy.daggerlearning.di.module.ActivityBuilderModule
import dev.iamsandy.daggerlearning.di.module.AppModule

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<PlayDumpApp> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}