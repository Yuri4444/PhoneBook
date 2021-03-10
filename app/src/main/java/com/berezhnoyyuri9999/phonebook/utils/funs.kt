package com.berezhnoyyuri9999.phonebook.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message : String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
