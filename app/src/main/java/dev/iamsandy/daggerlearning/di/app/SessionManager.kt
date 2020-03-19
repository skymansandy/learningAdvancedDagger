package dev.iamsandy.daggerlearning.di.app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import dev.iamsandy.daggerlearning.ui.auth.model.AuthResource
import dev.iamsandy.daggerlearning.ui.auth.model.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    companion object {
        const val TAG = "SessionManager"
    }

    private val cachedUser = MediatorLiveData<AuthResource<User>>()

    fun authenticateUserWithId(source: LiveData<AuthResource<User>>) {
        cachedUser.value = AuthResource.loading()
        cachedUser.addSource(source) {
            cachedUser.value = it
            cachedUser.removeSource(source)
        }
    }

    fun logout() {
        Log.d(TAG, "Logging out!")
        cachedUser.value = AuthResource.logout(null)
    }

    fun observeUser(): LiveData<AuthResource<User>> {
        return cachedUser
    }
}