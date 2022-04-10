package com.example.shoppinglist.ui.details

import androidx.annotation.WorkerThread
import com.example.shoppinglist.persistence.ProductDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val productDao: ProductDao
) {
    @WorkerThread
    fun getProductById(id: Long) = flow {
        val product = productDao.getProduct(id)
        emit(product)
    }.flowOn(Dispatchers.IO)
}