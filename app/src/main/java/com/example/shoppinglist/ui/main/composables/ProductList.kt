package com.example.shoppinglist.ui.main.composables


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.model.Product
import com.google.accompanist.insets.statusBarsPadding
import com.example.shoppinglist.Utility.items

@Composable
fun ProductList(
    modifier: Modifier,
    products: List<Product>,
    selectProduct: (String) -> Unit,
    requestMore: () -> Unit
) {
    LazyColumn(modifier = modifier.statusBarsPadding()) {
        items(
            items = products,
            itemContent = { product ->
                ProductRow(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    product = product,
                    selectProduct = { selectProduct(product.id) }
                )
            }) {
            requestMore()
        }
    }
}