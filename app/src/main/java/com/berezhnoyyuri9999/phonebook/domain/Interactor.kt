package com.berezhnoyyuri9999.phonebook.domain

import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.lang.Exception

class Interactor(private val app: App) {

    private val room by lazy { app.getRepository() }


    fun insert(note: AppNote) = CoroutineScope(IO).launch {
        room.insert(note)
    }

    fun delete(note: AppNote) = CoroutineScope(IO).launch {
        room.delete(note)
    }

    fun update(note: AppNote) = CoroutineScope(IO).launch {
        room.update(note)
    }


//    fun selectAllContacts() = CoroutineScope(IO).async {
//        room.selectAllContacts()
//    }


    fun selectAllContacts(): Observable<List<AppNote>> {
        return room.selectAllContacts()
            .subscribeOn(Schedulers.io())
    }

//    fun selectAllContacts() = CoroutineScope(IO).launch  {
//         room.selectAllContacts()
//    }

}


//    fun insert(note: AppNote): Observable<Boolean> {
//        return room.insert(note)
//            .map { it > 1 }
//            .subscribeOn(Schedulers.io())
//    }
//
//    fun delete(note: AppNote): Observable<Unit> {
//        return room.delete(note)
//            .subscribeOn(Schedulers.io())
//    }
//
//    fun update(note: AppNote): Observable<Unit> {
//        return room.update(note)
//            .subscribeOn(Schedulers.io())
//    }
//

