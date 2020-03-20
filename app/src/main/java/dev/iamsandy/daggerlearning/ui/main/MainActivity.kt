package dev.iamsandy.daggerlearning.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import dev.iamsandy.daggerlearning.R
import dev.iamsandy.daggerlearning.databinding.ActivityMainBinding
import dev.iamsandy.daggerlearning.ui.base.BaseActivity

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var vm: MainViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
        NavigationUI.setupWithNavController(binding.navView, navController)
        binding.navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                sessionManager.logout()
                return true
            }
            android.R.id.home -> {
                return if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                } else {
                    false
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navOptions = NavOptions.Builder()
            .setPopUpTo(R.id.main, true)
            .build()

        when (item.itemId) {
            R.id.nav_profile ->
                navController.navigate(R.id.profileFragment, null, navOptions)
            R.id.nav_posts ->
                if (isValidDestination(R.id.postsFragment))
                    navController.navigate(R.id.postsFragment)
        }
        binding.drawerLayout.closeDrawer(Gravity.START)
        return true
    }

    private fun isValidDestination(destination: Int): Boolean {
        return destination != navController.currentDestination?.id
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerLayout)
    }
}
