package com.berezhnoyyuri9999.phonebook.utils

import android.content.Context
import android.widget.Toast
import com.berezhnoyyuri9999.phonebook.MainActivity
import kotlinx.coroutines.*
import java.lang.Exception

fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}


fun <T> CoroutineScope.ioToUi(
    io: suspend () -> T,
    ui: (T) -> Unit,
    exception: ((Exception) -> Unit)? = null
): Job {
    return launch(Dispatchers.IO) {
        try {
            val result = io()
            withContext(Dispatchers.Main) {
                ui(result)
            }
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                exception?.invoke(e)
            }
        }
    }
}