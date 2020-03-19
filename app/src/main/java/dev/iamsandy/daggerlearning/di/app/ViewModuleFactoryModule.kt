package dev.iamsandy.daggerlearning.di.app

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dev.iamsandy.daggerlearning.viewmodels.ViewModelProviderFactory

@Module
abstract class ViewModuleFactoryModule {
    @Binds
    abstract fun providesViewModelFactory(
        viewModelFactory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}