package com.example.shoppinglist.ui.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {
    private var _products = mutableStateOf(value = listOf<Product>())
    val products: State<List<Product>> get() = _products

    private val _isLoading = mutableStateOf(value = false)
    val isLoading: State<Boolean> get() = _isLoading

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        viewModelScope.launch(context = Dispatchers.Main) {
            mainRepository.getProductList(
                onStart = { _isLoading.value = true },
                onCompletion = { _isLoading.value = false }
            ).collect {
                _products.value = it
            }
        }
    }
}