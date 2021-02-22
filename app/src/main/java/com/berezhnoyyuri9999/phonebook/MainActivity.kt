package com.berezhnoyyuri9999.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToolbar()

        APP_ACTIVITY = this
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    }


    private fun addToolbar() {
        mToolbar = toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.main_title)
    }
}