package com.example.dukaan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private val homeFragment by lazy {
        HomeFragment.newInstance()
    }
    private val ordersFragment by lazy {
        OrdersFragment.newInstance()
    }
    private val productsFragment by lazy {
        ProductsFragment.newInstance()
    }
    private val marketingFragment by lazy {
        MarketingFragment.newInstance()
    }
    private val accountsFragment by lazy {
        AccountsFragment.newInstance()
    }




    private val bottomNavView by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_nav_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNavigation()

        if (savedInstanceState == null) {
//        add all the fragments
            addFragment(homeFragment, "home_fragment", R.id.fragment_container)
            addFragment(ordersFragment, "orders_fragment", R.id.fragment_container)
            addFragment(productsFragment, "products_fragment", R.id.fragment_container)
            addFragment(marketingFragment, "marketing_fragment", R.id.fragment_container)
            addFragment(accountsFragment, "accounts_fragment", R.id.fragment_container)
//        hide all fragments and will show according to selected item lately
            hideAllFragments()
            bottomNavView.selectedItemId = R.id.navigation_home

            val badge = bottomNavView.getOrCreateBadge(R.id.navigation_orders)
            badge.number = 3
            badge.backgroundColor = ContextCompat.getColor(baseContext, R.color.cherry_red)
        }



    }

    private fun hideAllFragments() {
        hideFragment(homeFragment)
        hideFragment(ordersFragment)
        hideFragment(productsFragment)
        hideFragment(marketingFragment)
        hideFragment(accountsFragment)
    }

    private fun setBottomNavigation() {
        bottomNavView.setOnNavigationItemSelectedListener {
            hideAllFragments()
            when (it.itemId) {
                R.id.navigation_home -> {
                    showFragment(homeFragment)
                    true
                }
                R.id.navigation_orders -> {
                    showFragment(ordersFragment)
                    true
                }
                R.id.navigation_products -> {
                    showFragment(productsFragment)
                    true
                }
                R.id.navigation_marketing -> {
                    showFragment(marketingFragment)
                    true
                }
                R.id.navigation_accounts -> {
                    showFragment(accountsFragment)
                    true
                }
                else -> { false }
            }
        }
    }



}