package dev.iamsandy.daggerlearning.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import dev.iamsandy.daggerlearning.di.app.SessionManager
import dev.iamsandy.daggerlearning.ui.auth.model.AuthResource
import dev.iamsandy.daggerlearning.ui.auth.model.User
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthViewModel @Inject constructor(
    val sessionManager: SessionManager,
    private val authApi: AuthApi
) : ViewModel() {

    fun loginWithId(userId: String) {
        sessionManager.authenticateUserWithId(queryUserId(userId))
    }

    private fun queryUserId(userId: String): LiveData<AuthResource<User>> {
        return LiveDataReactiveStreams
            .fromPublisher(
                authApi.getUsers(userId)
                    .onErrorReturn {
                        return@onErrorReturn User(id = -1)
                    }.map {
                        return@map when (it.id) {
                            -1 -> AuthResource.error("Could not authenticate", it)
                            else -> AuthResource.authenticated(it)
                        }
                    }
                    .subscribeOn(Schedulers.io())
            )
    }
}