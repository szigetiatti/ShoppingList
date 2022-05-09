package com.example.shoppinglist.persistence.mapping

import com.example.shoppinglist.model.Product
import com.example.shoppinglist.persistence.ProductDto

fun ProductDto.toProduct() = Product(
    id = _id ?: "",
    name = name ?: "default",
    order = order,
    family = family
)