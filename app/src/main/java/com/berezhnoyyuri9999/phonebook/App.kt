package com.berezhnoyyuri9999.phonebook

import com.berezhnoyyuri9999.phonebook.data.repository.DatabaseRepository

interface App {

    fun getRepository() : DatabaseRepository



}