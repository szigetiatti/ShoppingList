package com.example.shoppinglist.ui.details.composables


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.R
import com.example.shoppinglist.ui.base.composables.AppBar

@Composable
fun BackButtonBar(
    pressOnBack: () -> Unit
) {
    AppBar(title = stringResource(id = R.string.product)) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            tint = Color.White,
            contentDescription = null,
            modifier = Modifier
                .padding(all = 12.dp)
                .clickable(onClick = pressOnBack)
        )
    }
}