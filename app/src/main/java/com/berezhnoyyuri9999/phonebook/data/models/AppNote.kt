package com.berezhnoyyuri9999.phonebook.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "notes_tables")
data class AppNote(

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo
    val name : String = "",

    @ColumnInfo
    val surname : String = "",

    @ColumnInfo
    val number : String = ""

) : Serializable