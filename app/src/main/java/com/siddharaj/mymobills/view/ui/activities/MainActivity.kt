package com.siddharaj.mymobills.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.siddharaj.mymobills.R
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var mNavController: NavController
    private lateinit var navView: BottomNavigationView
    private lateinit var bottomAppBar: BottomAppBar
    private var isShowBottomNav = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = findViewById(R.id.bottomNavigationView)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        bottomAppBar = findViewById(R.id.bottomAppBar)
        mNavController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.firstFragment, R.id.secondFragment
            )
        )
        setupActionBarWithNavController(mNavController, appBarConfiguration)

        navView.setupWithNavController(mNavController)

        fab.setOnClickListener {
            mNavController.navigate(R.id.createInvoiceFragment)
        }


        mNavController.addOnDestinationChangedListener { _, destination, _ ->
            // Show or hide navigation
            when (destination.id) {
                R.id.firstFragment, R.id.secondFragment -> {
                    showBottomNav()
                    bottomAppBar.visibility = View.VISIBLE
                    fab.show()
                }
                else -> {
                    hideBottomNav()
                    bottomAppBar.visibility = View.GONE
                    fab.hide()
                }
            }
        }



    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }

    /**
     * Show navigation
     */
    private fun showBottomNav() {
        if (!isShowBottomNav) {
            bottomAppBar.clearAnimation()
            navView.clearAnimation()

            navView.animate().translationY(0f).duration = 300
            bottomAppBar.animate().translationY(0f).duration = 300
            isShowBottomNav = true
        }
    }

    /**
     * Hide navigation
     */
    private fun hideBottomNav() {
        if (isShowBottomNav) {
            bottomAppBar.clearAnimation()
            navView.clearAnimation()
            navView.animate().translationY(navView.height.toFloat()).duration = 300
            bottomAppBar.animate().translationY(bottomAppBar.height.toFloat()).duration = 300
            isShowBottomNav = false
        }
    }
}