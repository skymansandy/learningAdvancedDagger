package dev.iamsandy.daggerlearning.ui.auth

import dev.iamsandy.daggerlearning.ui.auth.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthApi {

    @GET("/users/{user_id}")
    fun getUsers(@Path("user_id") userId: String): Flowable<User>
}