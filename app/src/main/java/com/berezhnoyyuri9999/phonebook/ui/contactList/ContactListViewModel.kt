package com.berezhnoyyuri9999.phonebook.ui.contactList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.DatabaseRepository
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDatabase

class ContactListViewModel(application: Application) : AndroidViewModel(application) {

//    private val readAllNotes: List<AppNote>
//    private val repository : DatabaseRepository
//
//    init {
//        val dao = AppRoomDatabase.getInstance(application).getAppRoomDao()
//        repository = DatabaseRepository(dao)
//        readAllNotes = repository.allNotes
//    }
}