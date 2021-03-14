package com.berezhnoyyuri9999.phonebook.domain

import com.berezhnoyyuri9999.phonebook.App
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

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

    suspend fun selectAllContacts() = room.selectAllNotes()

}