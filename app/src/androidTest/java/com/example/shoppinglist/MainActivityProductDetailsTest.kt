package com.example.shoppinglist

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.shoppinglist.ui.Screen
import com.example.shoppinglist.ui.details.composables.DetailsScreen
import com.example.shoppinglist.ui.main.MainActivity
import com.example.shoppinglist.ui.main.MainViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityProductDetailsTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var activity: MainActivity

    @Before
    fun init() {
        composeTestRule.activityRule.scenario.onActivity {
            activity = it
        }
    }

    @Test
    fun posterDetailsShibaInuLoadingTest() {
        composeTestRule.setContent {
            MaterialTheme {

                val viewModel = hiltViewModel<MainViewModel>()
                viewModel.loadProducts()

                Screen()
            }
        }

        composeTestRule
            .onNodeWithText("Something", ignoreCase = true)
            .assertIsDisplayed()
    }
}