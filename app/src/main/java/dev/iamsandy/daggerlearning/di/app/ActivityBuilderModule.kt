package dev.iamsandy.daggerlearning.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.iamsandy.daggerlearning.di.auth.AuthModule
import dev.iamsandy.daggerlearning.di.auth.AuthScope
import dev.iamsandy.daggerlearning.di.auth.AuthViewModelModule
import dev.iamsandy.daggerlearning.ui.auth.AuthActivity

@Module
abstract class ActivityBuilderModule {

    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthViewModelModule::class, AuthModule::class]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}