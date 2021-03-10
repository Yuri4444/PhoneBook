package com.berezhnoyyuri9999.phonebook

import android.app.Application
import com.berezhnoyyuri9999.phonebook.data.room.AppRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BookApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppRoomDatabase.getDatabase(this) }
    val repository by lazy { DatabaseRepository(database.getAppRoomDao()) }

}