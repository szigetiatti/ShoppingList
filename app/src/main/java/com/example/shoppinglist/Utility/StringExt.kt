package com.example.shoppinglist.Utility

import android.util.Log

fun String.print(tag: String = "PRODUCTS") {
    Log.d(tag, this)
}