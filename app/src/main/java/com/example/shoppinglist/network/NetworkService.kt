package com.example.shoppinglist.network

import com.example.shoppinglist.model.Product
import com.example.shoppinglist.persistence.ProductListResponseDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.*

interface NetworkService {
    @GET("all")
    suspend fun fetchProductList(): ApiResponse<List<Product>>

    @GET("all")
    suspend fun getProductList(@Query("count") count: String): ApiResponse<ProductListResponseDto>
}