package com.example.shoppinglist.ui.main

import androidx.annotation.WorkerThread
import com.example.shoppinglist.network.NetworkService
import com.example.shoppinglist.persistence.ProductDao
import com.example.shoppinglist.persistence.mapping.toProducts
import com.example.shoppinglist.ui.base.BaseRepository
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val networkService: NetworkService,
    private val productDao: ProductDao
): BaseRepository() {
    companion object {
        const val PAGE_SIZE = "5"
    }

    @WorkerThread
    fun getProductList(
        onStart: () -> Unit,
        onCompletion: () -> Unit,
        onError: (String) -> Unit = { }
    ) = flow {
        val products = productDao.getProductList()
        if (products.isEmpty()) {
            networkService.getProductList(count = PAGE_SIZE)
                .suspendOnSuccess {
                    val newProducts = data.toProducts() + products
                    productDao.insertProductList(posters = newProducts)
                    emit(newProducts)
                }
                .onError {
                    onError("ERROR")
                }
                .onException {
                    onError("ERROR")
                }
        } else {
            emit(value = products)
        }
    }.onStart { onStart() }.onCompletion { onCompletion() }.flowOn(context = Dispatchers.IO)
}