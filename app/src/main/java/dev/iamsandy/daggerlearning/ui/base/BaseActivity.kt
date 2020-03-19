package dev.iamsandy.daggerlearning.ui.base

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import dev.iamsandy.daggerlearning.di.app.SessionManager
import dev.iamsandy.daggerlearning.ui.auth.AuthActivity
import dev.iamsandy.daggerlearning.ui.auth.model.AuthResource
import dev.iamsandy.daggerlearning.ui.auth.model.User
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    companion object {
        const val TAG = "BaseActivity"
    }

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeUserObserver()
    }

    private fun subscribeUserObserver() {
        sessionManager.observeUser()
            .observe(this, Observer<AuthResource<User>> {
                when (it.status) {
                    AuthResource.Status.LOADING -> {
                        Log.d(AuthActivity.TAG, "User loading..")
                    }
                    AuthResource.Status.NOT_AUTHENTICATED -> {
                        Log.d(AuthActivity.TAG, "User logged out")
                        navigateToLogin()
                    }
                    AuthResource.Status.AUTHENTICATED -> {
                        Log.d(AuthActivity.TAG, "User logged in")
                    }
                    AuthResource.Status.ERROR -> {
                        Log.d(AuthActivity.TAG, "Login Failure")
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })
    }

    private fun navigateToLogin() {
        startActivity(Intent(this, AuthActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        }).also {
            finish()
        }
    }
}