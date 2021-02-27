package com.berezhnoyyuri9999.phonebook.utils

import android.content.Context
import android.widget.Toast
import com.berezhnoyyuri9999.phonebook.MainActivity

fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
