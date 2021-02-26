package com.berezhnoyyuri9999.phonebook

import com.berezhnoyyuri9999.phonebook.data.models.AppNote

interface CommunicatorAdapter {

    fun clickItem(note : AppNote, onSuccess:() -> Unit)

}