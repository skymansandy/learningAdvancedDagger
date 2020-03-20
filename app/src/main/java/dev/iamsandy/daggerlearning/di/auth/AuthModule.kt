package dev.iamsandy.daggerlearning.di.auth

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.ui.auth.AuthApi
import dev.iamsandy.daggerlearning.ui.auth.model.User
import retrofit2.Retrofit
import javax.inject.Named

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    @AuthScope
    @Provides
    @Named("auth_user")
    fun provideUser(): User {
        return User(id = 1)
    }
}