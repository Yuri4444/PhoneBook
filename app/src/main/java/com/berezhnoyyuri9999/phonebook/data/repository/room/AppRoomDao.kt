package com.berezhnoyyuri9999.phonebook.data.repository.room


import androidx.room.*
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface AppRoomDao {

    @Query("SELECT * FROM notes_tables")
    fun getAllNotes(): List<AppNote>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: AppNote) : Long

    @Delete
    fun deleteNote(note: AppNote)

    @Update
    fun updateNote(note: AppNote)
}


