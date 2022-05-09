package hu.bme.aut.dadjokes.ui.details.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.R
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.ui.base.composables.ProductText

@Composable
fun ProductDetailsRow(
    modifier: Modifier = Modifier,
    product: Product,
    pressOnBack: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            elevation = 16.dp,
            shape = RoundedCornerShape(size = 24.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.LightGray)
                    .padding(paddingValues = PaddingValues(all = 8.dp))
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                ProductText(
                    modifier = Modifier.align(alignment = Alignment.Start),
                    text = product.name,
                    padding = PaddingValues(all = 8.dp),
                    backgroundColor = MaterialTheme.colors.primarySurface
                )

                ProductText(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    text = product.family,
                    style = MaterialTheme.typography.h5
                )

                ProductText(
                    modifier = Modifier.align(alignment = Alignment.End),
                    text = product.order,
                    padding = PaddingValues(all = 8.dp),
                    backgroundColor = MaterialTheme.colors.primarySurface
                )
            }
        }

        Spacer(modifier = Modifier.size(size = 64.dp))

        ProductText(
            modifier = Modifier.clickable(onClick = pressOnBack),
            text = stringResource(id = R.string.show_more_products),
            padding = PaddingValues(all = 16.dp),
            style = MaterialTheme.typography.h6,
            backgroundColor = MaterialTheme.colors.primarySurface
        )
    }
}