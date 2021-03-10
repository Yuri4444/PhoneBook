package com.berezhnoyyuri9999.phonebook.data.repository

import androidx.lifecycle.LiveData
import com.berezhnoyyuri9999.phonebook.data.models.AppNote

interface DatabaseRepository {

    val allNotes: List<AppNote>
     fun insert(note: AppNote)
     fun delete(note: AppNote)

}