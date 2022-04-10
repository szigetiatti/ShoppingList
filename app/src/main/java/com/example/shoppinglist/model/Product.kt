package com.example.shoppinglist.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import okhttp3.internal.threadName

@Entity
@Immutable
data class Product(
    @PrimaryKey val id: String,
    val name: String,
    val protein: String,
    val calories: String
){
    companion object {
        fun mock() = Product(
            id = "0",
            name = "food",
            protein = "much",
            calories = "zero"
        )
    }
}