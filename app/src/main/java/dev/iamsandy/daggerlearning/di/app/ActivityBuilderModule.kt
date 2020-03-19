package dev.iamsandy.daggerlearning.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.iamsandy.daggerlearning.di.auth.AuthModule
import dev.iamsandy.daggerlearning.di.auth.AuthScope
import dev.iamsandy.daggerlearning.di.auth.AuthViewModelModule
import dev.iamsandy.daggerlearning.di.main.MainFragmentBuildersModule
import dev.iamsandy.daggerlearning.di.main.MainModule
import dev.iamsandy.daggerlearning.di.main.MainViewModelModule
import dev.iamsandy.daggerlearning.ui.auth.AuthActivity
import dev.iamsandy.daggerlearning.ui.main.MainActivity

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity

    @ContributesAndroidInjector(
        modules = [MainFragmentBuildersModule::class,
            MainViewModelModule::class,
            MainModule::class]
    )
    abstract fun contributeMainActivity(): MainActivity
}