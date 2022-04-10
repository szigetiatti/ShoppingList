package com.example.shoppinglist.ui.main

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.shoppinglist.ui.AppBar
import com.example.shoppinglist.ui.NavScreen
import com.example.shoppinglist.ui.details.DetailsScreen
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Home.route) {
            composable(NavScreen.Home.route) {
                Scaffold(topBar = { AppBar() }) {
                    Button(onClick = {
                        navController.navigate("${NavScreen.Details.route}/111")
                    }) {
                        Text(text = "Navigate next")
                    }
                }
            }
            composable(
                route = NavScreen.Details.routeWithArgument,
                arguments = listOf(
                    navArgument(NavScreen.Details.argument0) { type = NavType.LongType }
                )
            ) { _ ->
                DetailsScreen {
                    navController.navigateUp()
                }
            }
        }
    }
}