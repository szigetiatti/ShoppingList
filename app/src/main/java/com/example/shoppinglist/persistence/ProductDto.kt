package com.example.shoppinglist.persistence

data class ProductDto(
    val name: String,
    val order: String,
    val family: String,
    val _id: String? = null,
)