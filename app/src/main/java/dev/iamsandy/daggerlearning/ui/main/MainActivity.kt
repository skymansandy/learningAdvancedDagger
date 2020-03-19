package dev.iamsandy.daggerlearning.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import dev.iamsandy.daggerlearning.R
import dev.iamsandy.daggerlearning.databinding.ActivityMainBinding
import dev.iamsandy.daggerlearning.ui.base.BaseActivity
import dev.iamsandy.daggerlearning.ui.post.PostsFragment
import dev.iamsandy.daggerlearning.ui.profile.ProfileFragment

class MainActivity : BaseActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PostsFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> sessionManager.logout()
        }
        return true
    }
}
