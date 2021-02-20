package com.berezhnoyyuri9999.phonebook.ui.start


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.provider.ContactsContract
import android.util.Log
import com.berezhnoyyuri9999.phonebook.MainActivity
import com.berezhnoyyuri9999.phonebook.R
import com.berezhnoyyuri9999.phonebook.RoomApplication
//import com.berezhnoyyuri9999.phonebook.data.repository.AppRoomRepository

import com.berezhnoyyuri9999.phonebook.data.repository.DatabaseRepository
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDatabase
import com.berezhnoyyuri9999.phonebook.utils.APP_ACTIVITY
import com.berezhnoyyuri9999.phonebook.utils.REPOSITORY

import com.berezhnoyyuri9999.phonebook.utils.TYPE_ROOM
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers

class StartPresenter(application: Context) : StartContract.StartPresenter {




    private val mContext = application

    private var view: StartContract.StartView? = null

    override fun clickBook() {
        APP_ACTIVITY.navController.navigate(R.id.action_startFragment_to_listFragment)
    }

    override fun bindView(view: StartContract.StartView) {
        this.view = view
    }

    override fun unBind() {
        view = null
    }


    override fun initDatabase(type: String, onSuccess: () -> Unit) {

        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = DatabaseRepository(dao)
                onSuccess()
            }
        }
    }
}