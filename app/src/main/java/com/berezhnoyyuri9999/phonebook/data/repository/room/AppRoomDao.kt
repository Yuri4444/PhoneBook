package com.berezhnoyyuri9999.phonebook.data.repository.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.berezhnoyyuri9999.phonebook.data.models.AppNote
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.flow.Flow

@Dao
interface AppRoomDao {

//    @Query("SELECT * FROM notes_tables")
//    fun getAllNotes(): LiveData<List<AppNote>>


//    @Query("SELECT * FROM notes_tables")
//    suspend fun getAllNotes(): List<AppNote>

    @Query("SELECT * FROM notes_tables")
    fun getAllNotes(): List<AppNote>

//    @Query("SELECT * FROM notes_tables")
//    suspend fun getAllNotes(): Deferred<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: AppNote)

    @Delete
    suspend fun deleteNote(note: AppNote)

    @Update
    suspend fun updateNote(note: AppNote)
}