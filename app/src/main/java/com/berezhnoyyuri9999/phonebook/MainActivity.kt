package com.berezhnoyyuri9999.phonebook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContactNavController {

    lateinit var navController: NavController
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToolbar()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    private fun addToolbar() {
        mToolbar = toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.main_title)
    }

    override fun navController(): NavController {
        return navController
    }
}