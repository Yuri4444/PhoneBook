package com.berezhnoyyuri9999.phonebook.data.repository



import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import com.berezhnoyyuri9999.phonebook.data.repository.room.AppRoomDao
import io.reactivex.Observable


//interface DatabaseRepository {
//    val allNotes : List<AppNote>
//
//    fun insert(note : AppNote, onSuccess:() -> Unit)
//
//    fun delete(note: AppNote, onSuccess: () -> Unit)
//
//}

class DatabaseRepository(private val appRoomDao: AppRoomDao) {

    fun insert(note : AppNote) : Observable<Boolean> =
        Observable.fromCallable { appRoomDao.insertNote(note) }
            .map { it > 0 }

    fun selectAllContacts() : Observable<List<AppNote>> =
        Observable.fromCallable { appRoomDao.getAllNotes() }


    fun delete(note: AppNote) {
        appRoomDao.deleteNote(note)
    }

}