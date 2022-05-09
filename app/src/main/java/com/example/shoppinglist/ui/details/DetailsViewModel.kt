package com.example.shoppinglist.ui.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.ui.NavScreen
import com.example.shoppinglist.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailRepository: DetailsRepository,
    savedStateHandle: SavedStateHandle
): BaseViewModel() {
    private var _product = mutableStateOf(value = Product.mock())
    val product: State<Product> get() = _product

    init {
        val productId = savedStateHandle.get<String>(NavScreen.Details.argument0)
        productId?.let {
            viewModelScope.launch(context = Dispatchers.Main) {
                detailRepository.getProductById(id = it).collect {
                        it?.let {
                            _product.value = it
                        }
                    }
            }
        }
    }
}