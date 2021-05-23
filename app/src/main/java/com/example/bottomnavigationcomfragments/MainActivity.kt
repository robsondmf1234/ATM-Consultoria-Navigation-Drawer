package com.example.bottomnavigationcomfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyboardShortcutGroup
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import kotlinx.android.synthetic.main.activity_main.fragment_container

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        makeCurretFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    val homeFragment = HomeFragment()
                    makeCurretFragment(homeFragment)
                }
                R.id.favoriteFragment -> {
                    val favoriteFragment = FavoriteFragment()
                    makeCurretFragment(favoriteFragment)
                }
                R.id.searchFragment -> {
                    val searchFragment = SearchFragment()
                    makeCurretFragment(searchFragment)
                }
            }
            true
        }
    }

    private fun makeCurretFragment(fragment: Fragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
        true
    }
}
