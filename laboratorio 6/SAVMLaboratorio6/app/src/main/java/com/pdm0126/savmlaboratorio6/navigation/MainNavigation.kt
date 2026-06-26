package com.pdm0126.savmlaboratorio6.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.savmlaboratorio6.ui.screens.MealScreen

@Composable
fun RecipeApp(modifier: Modifier) {
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backstack,
        onBack = { backstack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                MealScreen()
            }
        }
    )

}