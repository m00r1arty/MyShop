package com.radzhabov.onlineshop.presentation.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.radzhabov.onlineshop.R
import com.radzhabov.onlineshop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var navHostFragment: NavHostFragment
    lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navView = binding.navView
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_bottom) as NavHostFragment
        navController = navHostFragment.navController

        navView.setupWithNavController(navController)
    }
}