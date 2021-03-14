package com.berezhnoyyuri9999.phonebook.data.repository.room

import androidx.room.*
import com.berezhnoyyuri9999.phonebook.data.models.AppNote

@Dao
interface AppRoomDao {

    @Query("SELECT * FROM notes_tables")
    suspend fun getAllNotes(): List<AppNote>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: AppNote)

    @Delete
    suspend fun deleteNote(note: AppNote)

    @Update
    suspend fun updateNote(note: AppNote)
}