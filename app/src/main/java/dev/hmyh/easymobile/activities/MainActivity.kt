package dev.hmyh.easymobile.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import dev.hmyh.easymobile.R
import dev.hmyh.easymobile.fragments.HomeFragment
import dev.hmyh.easymobile.fragments.NewFragment
import dev.hmyh.easymobile.fragments.SaveFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpHomeFragment()
        setUpBottomNavigationBar()
    }

    private fun setUpHomeFragment() {
        fragmentManager = supportFragmentManager
        val fragment = HomeFragment()
        loadFragment(fragment)
    }

    private fun setUpBottomNavigationBar() {
        bottom_navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.menu_home -> {
                    val fragment = HomeFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_new -> {
                    val fragment = NewFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_save -> {
                    val fragment = SaveFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    val fragment = HomeFragment()
                    loadFragment(fragment)
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
    }

    fun loadFragment(fragment: Fragment){
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout_container,fragment)
        transaction.commit()
    }
}
