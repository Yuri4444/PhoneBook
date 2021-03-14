package com.berezhnoyyuri9999.phonebook.data.repository

import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao

class DatabaseRepository(private val appRoomDao: AppRoomDao) {

    suspend fun selectAllNotes(): List<AppNote> {
        return appRoomDao.getAllNotes()
    }

    suspend fun insert(note: AppNote) {
        appRoomDao.insertNote(note)
    }

    suspend fun delete(note: AppNote) {
        appRoomDao.deleteNote(note)
    }

    suspend fun update(note: AppNote) {
        appRoomDao.updateNote(note)
    }

}