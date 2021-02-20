package com.berezhnoyyuri9999.phonebook.data.repository

import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao


//
//class AppRoomRepository(private val appRoomDao: AppRoomDao) : DatabaseRepository {
//
//    override val allNotes: List<AppNote>
//        get() = appRoomDao.getAllNotes()
//
//    override fun insert(note: AppNote, onSuccess: () -> Unit) {
//        appRoomDao.insertNote(note)
//        onSuccess()
//    }
//
//    override fun delete(note: AppNote, onSuccess: () -> Unit) {
//        appRoomDao.deleteNote(note)
//        onSuccess()
//    }
//}