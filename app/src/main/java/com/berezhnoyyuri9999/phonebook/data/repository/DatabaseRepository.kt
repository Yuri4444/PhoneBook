package com.berezhnoyyuri9999.phonebook.data.repository

import androidx.lifecycle.LiveData
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao
import io.reactivex.Observable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred


class DatabaseRepository(private val appRoomDao: AppRoomDao) {

//    suspend fun selectAllContacts() : List<AppNote> {
//        return appRoomDao.getAllNotesAsync().await()
//    }

    fun selectAllContacts(): Observable<List<AppNote>> =
    Observable.fromCallable { appRoomDao.getAllNotes() }

    suspend fun insert(note: AppNote) { appRoomDao.insertNote(note) }

    suspend fun delete(note: AppNote) { appRoomDao.deleteNote(note) }

    suspend fun update(note: AppNote) { appRoomDao.updateNote(note) }

}


//fun selectAllContacts(): Observable<List<AppNote>> =
//    Observable.fromCallable { appRoomDao.getAllNotes() }
//

//fun insert(note: AppNote): Observable<Long> =
//    Observable.fromCallable { appRoomDao.insertNote(note) }
//

//
//
//fun delete(note: AppNote): Observable<Unit> =
//    Observable.fromCallable { appRoomDao.deleteNote(note) }
//
//fun update(note: AppNote): Observable<Unit> =
//    Observable.fromCallable { appRoomDao.updateNote(note) }