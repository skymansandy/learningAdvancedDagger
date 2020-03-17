package dev.iamsandy.daggerlearning.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dev.iamsandy.daggerlearning.ui.auth.AuthActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}