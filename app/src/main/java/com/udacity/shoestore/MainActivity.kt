package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = this.findNavController(R.id.hostFragment)

        NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.shoeListFragment) {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() ||
                super.onSupportNavigateUp()
    }

}
