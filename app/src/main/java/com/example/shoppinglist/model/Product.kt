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
    val family: String,
    val order: String
){
    companion object {
        fun mock() = Product(
            id = "0",
            name = "food",
            family = "much",
            order = "zero"
        )
    }
}