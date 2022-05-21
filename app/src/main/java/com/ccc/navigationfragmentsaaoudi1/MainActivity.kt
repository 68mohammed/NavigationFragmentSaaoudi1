package com.ccc.navigationfragmentsaaoudi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var bottomNavigation :BottomNavigationView?=null
    private var frameLayout:FrameLayout?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectView()
        bottomNavigationClicks()
    }
    private fun bottomNavigationClicks() {
        bottomNavigation?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{chooseFragment(HomeFragment(),"HOME")

                }
                R.id.settings ->{chooseFragment(SettingsFragment(),"SETTINGS")
                }
                R.id.profile ->{chooseFragment(ProfileFragment(),"PROFILE")
                }

            }
            true
        }
    }
    ////////////////////////
    private fun chooseFragment(fragment: Fragment,tag:String) {
val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.commit()
    }
    private fun connectView() {
        bottomNavigation=findViewById(R.id.bottonNav)
        frameLayout=findViewById(R.id.fContainer)
    }
}