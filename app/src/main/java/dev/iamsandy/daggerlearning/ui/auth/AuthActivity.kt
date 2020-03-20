package dev.iamsandy.daggerlearning.ui.auth

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import dev.iamsandy.daggerlearning.R
import dev.iamsandy.daggerlearning.databinding.ActivityAuthBinding
import dev.iamsandy.daggerlearning.ui.auth.model.AuthResource
import dev.iamsandy.daggerlearning.ui.auth.model.User
import dev.iamsandy.daggerlearning.ui.main.MainActivity
import dev.iamsandy.daggerlearning.viewmodels.ViewModelProviderFactory
import javax.inject.Inject
import javax.inject.Named

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        const val TAG = "AuthActivity"
    }

    private lateinit var binding: ActivityAuthBinding

    private lateinit var vm: AuthViewModel
    private val progressDialog by lazy {
        ProgressDialog(this)
    }

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    @Inject
    lateinit var authApi: AuthApi

    @Inject
    @Named("app_user")
    lateinit var userApp: User

    @Inject
    @Named("auth_user")
    lateinit var userAuth: User

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        vm = ViewModelProvider(this, vmFactory).get(AuthViewModel::class.java)
        setLogo()

        binding.loginButton.setOnClickListener {
            val userId = binding.userIdInput.text.toString()
            if (!TextUtils.isEmpty(userId)) {
                vm.loginWithId(userId)
            } else {
                binding.userIdInputLayout.error = "Can't be empty"
            }
        }

        vm.sessionManager.observeUser()
            .observe(this, Observer<AuthResource<User>> {
                when (it.status) {
                    AuthResource.Status.LOADING -> {
                        showProgressBar()
                        Log.d(TAG, "User loading..")
                    }
                    AuthResource.Status.NOT_AUTHENTICATED -> {
                        hideProgressBar()
                        Log.d(TAG, "User logged out")
                    }
                    AuthResource.Status.AUTHENTICATED -> {
                        hideProgressBar()
                        Log.d(TAG, "User logged in")
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    AuthResource.Status.ERROR -> {
                        hideProgressBar()
                        Log.d(TAG, "Login Failure")
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            })

        Log.d(TAG, "App User: $userApp")
        Log.d(TAG, "App User: $userAuth")
    }

    private fun showProgressBar() {
        (!progressDialog.isShowing).let {
            progressDialog.show()
        }
    }

    private fun hideProgressBar() {
        progressDialog.isShowing.let {
            progressDialog.dismiss()
        }
    }

    private fun setLogo() {
        requestManager.load(logo)
            .into(binding.loginLogo)
    }
}
