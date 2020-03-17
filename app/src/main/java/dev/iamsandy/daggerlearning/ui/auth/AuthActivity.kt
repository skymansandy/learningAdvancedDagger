package dev.iamsandy.daggerlearning.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import dev.iamsandy.daggerlearning.R
import dev.iamsandy.daggerlearning.databinding.ActivityAuthBinding
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    companion object {
        const val TAG = "AuthActivity"
    }

    private lateinit var binding: ActivityAuthBinding

    @Inject
    lateinit var logo: Drawable

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        setLogo()
    }

    private fun setLogo() {
        requestManager.load(logo)
            .into(binding.loginLogo)
    }
}
