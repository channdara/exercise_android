package com.example.exercise_android.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.exercise_android.R
import com.example.exercise_android.ui.fragments.EmptyFragment
import com.example.exercise_android.ui.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        val homeFragment = HomeFragment()
        setCurrentFragment(homeFragment)
        main_bottom_nav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_coupon -> {
                    val emptyFragment = EmptyFragment()
                    EmptyFragment.newInstance(emptyFragment, getString(R.string.coupon))
                    setCurrentFragment(emptyFragment)
                }
                R.id.nav_favorite -> {
                    val emptyFragment = EmptyFragment()
                    EmptyFragment.newInstance(emptyFragment, getString(R.string.favorite))
                    setCurrentFragment(emptyFragment)
                }
                R.id.nav_me -> {
                    val emptyFragment = EmptyFragment()
                    EmptyFragment.newInstance(emptyFragment, getString(R.string.me))
                    setCurrentFragment(emptyFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_content_view, fragment)
            commit()
        }
}