package com.example.shoppinglist.ui.main

import com.example.shoppinglist.network.NetworkService
import com.example.shoppinglist.persistence.ProductDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val productDao: ProductDao
)
