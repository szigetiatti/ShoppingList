package com.example.shoppinglist.network

import com.example.shoppinglist.model.Product
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface NetworkService {
    @GET("api/fruit/all")
    suspend fun fetchProductList(): ApiResponse<List<Product>>
}