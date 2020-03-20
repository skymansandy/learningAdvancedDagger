package dev.iamsandy.daggerlearning.di.app

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.ui.auth.model.User
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    @Named("app_user")
    fun provideUser(): User {
        return User(id = 1)
    }
}