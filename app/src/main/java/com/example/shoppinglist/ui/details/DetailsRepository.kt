package com.example.shoppinglist.ui.details

import androidx.annotation.WorkerThread
import com.example.shoppinglist.persistence.ProductDao
import com.example.shoppinglist.ui.base.BaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DetailsRepository @Inject constructor(
    private val productDao: ProductDao
) : BaseRepository() {
    @WorkerThread
    fun getProductById(id: String) = flow {
        val product = productDao.getProduct(id_ = id)
        emit(value = product)
    }.flowOn(context = Dispatchers.IO)
}