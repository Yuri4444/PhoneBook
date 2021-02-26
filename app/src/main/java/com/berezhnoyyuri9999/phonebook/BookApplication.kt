package com.berezhnoyyuri9999.phonebook

import android.app.Application
import android.content.Context
import com.berezhnoyyuri9999.phonebook.data.repository.DatabaseRepository
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDatabase

class BookApplication : Application(), App {

    lateinit var databaseRepository : DatabaseRepository

    override fun onCreate() {
        super.onCreate()

        val dao = AppRoomDatabase.getInstance(this).getAppRoomDao()
        databaseRepository = DatabaseRepository(dao)

    }

    override fun getRepository(): DatabaseRepository = databaseRepository

    companion object {
        fun getApp(context: Context?) : App {
            return context?.applicationContext as App
        }
    }
}