package com.berezhnoyyuri9999.phonebook.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


@Entity(tableName = "notes_tables")
data class AppNote(

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,

    @ColumnInfo
    var name : String = "",

    @ColumnInfo
    var surname : String = "",

    @ColumnInfo
    var number : String = ""

) : Serializable