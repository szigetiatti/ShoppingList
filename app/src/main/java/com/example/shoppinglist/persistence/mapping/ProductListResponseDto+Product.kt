package com.example.shoppinglist.persistence.mapping

import com.example.shoppinglist.persistence.ProductListResponseDto

fun ProductListResponseDto.toProducts() = body.map { it.toProduct() }