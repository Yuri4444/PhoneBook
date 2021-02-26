package com.berezhnoyyuri9999.phonebook.domain

import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class Interactor(private val app : App) {

    private val room by lazy { app.getRepository() }

    fun insert(note: AppNote) : Observable<Boolean> {
        return room.insert(note)
            .subscribeOn(Schedulers.io())
    }

    fun delete(note: AppNote) : Observable<Unit> {
        return room.delete(note)
            .subscribeOn(Schedulers.io())
    }

    fun update(note: AppNote) : Observable<Unit> {
        return room.update(note)
            .subscribeOn(Schedulers.io())
    }

    fun selectAllContacts() : Observable<List<AppNote>> {
        return room.selectAllContacts()
            .subscribeOn(Schedulers.io())
    }

}