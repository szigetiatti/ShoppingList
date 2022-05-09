package com.example.shoppinglist.ui.main.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shoppinglist.Utility.visible
import com.example.shoppinglist.ui.base.composables.AppBar
import com.example.shoppinglist.ui.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    selectProduct: (String) -> Unit
) {
    val products by viewModel.products
    val isLoading by viewModel.isLoading

    ConstraintLayout {
        val (_, progress) = createRefs()

        Scaffold(topBar = {
            AppBar()
        }) {
            ProductList(
                modifier = Modifier
                    .padding(paddingValues = it)
                    .alpha(alpha = if (isLoading) 0.5f else 1f),
                products = products,
                selectProduct = selectProduct
            ) {

            }
        }
        CircularProgressIndicator(
            modifier = Modifier
                .constrainAs(ref = progress) {
                    top.linkTo(anchor = parent.top)
                    bottom.linkTo(anchor = parent.bottom)
                    start.linkTo(anchor = parent.start)
                    end.linkTo(anchor = parent.end)
                }
                .visible(visibility = isLoading)
        )
    }
}