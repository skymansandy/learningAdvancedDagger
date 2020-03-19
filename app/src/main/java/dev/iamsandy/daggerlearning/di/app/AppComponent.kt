package dev.iamsandy.daggerlearning.di.app

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.iamsandy.daggerlearning.PlayDumpApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        GlideModule::class,
        ViewModuleFactoryModule::class,
        NetworkModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<PlayDumpApp> {

    fun provideSessionManager(): SessionManager

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}