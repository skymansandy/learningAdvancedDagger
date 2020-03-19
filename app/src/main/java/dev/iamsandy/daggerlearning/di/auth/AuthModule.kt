package dev.iamsandy.daggerlearning.di.auth

import dagger.Module
import dagger.Provides
import dev.iamsandy.daggerlearning.ui.auth.AuthApi
import retrofit2.Retrofit

@Module
class AuthModule {

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}