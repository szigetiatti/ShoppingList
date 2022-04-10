package com.example.shoppinglist.ui

sealed class NavScreen(val route: String) {
    object Home: NavScreen("Home")
    object Details: NavScreen("Details") {
        const val routeWithArgument = "Details/{productId}"
        const val argument0 = "productId"
    }
}