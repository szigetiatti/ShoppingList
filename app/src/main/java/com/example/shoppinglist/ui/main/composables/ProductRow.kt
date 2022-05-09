package com.example.shoppinglist.ui.main.composables


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.ui.base.composables.ProductText

@Composable
fun ProductRow(
    modifier: Modifier = Modifier,
    product: Product,
    selectProduct: () -> Unit = { },
) {
    Surface(
        modifier = modifier
            .padding(all = 4.dp)
            .clickable(onClick = selectProduct),
        elevation = 16.dp,
        shape = RoundedCornerShape(size = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(
                    paddingValues = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    )
                )
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProductText(text = product.name)
        }
    }
}