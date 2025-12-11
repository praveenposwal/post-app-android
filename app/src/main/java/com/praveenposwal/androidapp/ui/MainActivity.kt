package com.praveenposwal.androidapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.praveenposwal.androidapp.R
import com.praveenposwal.androidapp.ui.home.HomeFragment
import com.praveenposwal.androidapp.ui.login.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_navigation)

        setupBottomNavigation()

        if (savedInstanceState == null) {
            navigateTo(LoginFragment(), addToBackStack = false)
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    navigateTo(HomeFragment(), addToBackStack = false)
                    true
                }
                R.id.favoriteFragment -> {
                    navigateTo(com.praveenposwal.androidapp.ui.favorite.FavoriteFragment(), addToBackStack = false)
                    true
                }
                R.id.settingsFragment -> {
                    navigateTo(com.praveenposwal.androidapp.ui.settings.SettingsFragment(), addToBackStack = false)
                    true
                }
                else -> false
            }
        }
    }

    fun navigateTo(fragment: Fragment, addToBackStack: Boolean = true) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
        
        updateBottomNavVisibility(fragment)
    }

    private fun updateBottomNavVisibility(fragment: Fragment) {
        if (fragment is LoginFragment) {
            bottomNav.visibility = View.GONE
        } else {
            bottomNav.visibility = View.VISIBLE
        }
    }
    
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
