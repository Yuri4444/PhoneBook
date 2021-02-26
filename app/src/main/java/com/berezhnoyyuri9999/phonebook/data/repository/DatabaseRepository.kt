package com.berezhnoyyuri9999.phonebook.data.repository

import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao
import io.reactivex.Observable


class DatabaseRepository(private val appRoomDao: AppRoomDao) {

    fun insert(note : AppNote) : Observable<Boolean> =
        Observable.fromCallable { appRoomDao.insertNote(note) }
            .map { it > 1 }


    fun selectAllContacts() : Observable<List<AppNote>> =
        Observable.fromCallable { appRoomDao.getAllNotes() }


    fun delete(note: AppNote) : Observable<Unit> =
        Observable.fromCallable { appRoomDao.deleteNote(note) }

    fun update(note : AppNote) : Observable<Unit> =
        Observable.fromCallable { appRoomDao.updateNote(note) }




}