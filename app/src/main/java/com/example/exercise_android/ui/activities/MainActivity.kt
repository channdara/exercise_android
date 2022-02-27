package com.example.exercise_android.ui.activities

import android.Manifest
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exercise_android.R
import com.example.exercise_android.ui.fragments.EmptyFragment
import com.example.exercise_android.ui.fragments.HomeFragment
import com.example.exercise_android.ui.fragments.MapsFragment
import com.example.exercise_android.ui.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val searchFragment: SearchFragment = SearchFragment()
    val mapsFragment: MapsFragment = MapsFragment()
    private val homeFragment: HomeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestLocationPermission()
        setupBottomNavigation()
    }

    private fun requestLocationPermission() {
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {}
            .launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
    }

    private fun setupBottomNavigation() {
        replaceFragment(homeFragment)
        main_bottom_nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(homeFragment)
                R.id.nav_coupon -> replaceEmptyFragment("Coupon")
                R.id.nav_favorite -> replaceEmptyFragment("Favorite")
                R.id.nav_me -> replaceEmptyFragment("Me")
            }
            true
        }
    }

    private fun replaceEmptyFragment(title: String) {
        val emptyFragment = EmptyFragment()
        EmptyFragment.newInstance(emptyFragment, title)
        replaceFragment(emptyFragment)
    }

    private fun replaceFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content_view, fragment)
            commit()
        }

    fun addFragment(fragment: Fragment) {
        if (supportFragmentManager.fragments.contains(fragment)) return
        supportFragmentManager.beginTransaction().apply {
            add(R.id.main_content_view, fragment)
            addToBackStack(fragment.toString())
            commit()
        }
    }

    fun removeFragment(fragment: Fragment) {
        if (!(supportFragmentManager.fragments.contains(fragment))) return
        supportFragmentManager.beginTransaction().apply {
            remove(fragment)
            commit()
        }
    }

}