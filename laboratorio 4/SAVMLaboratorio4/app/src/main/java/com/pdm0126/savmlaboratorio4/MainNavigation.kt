package com.pdm0126.savmlaboratorio4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.savmlaboratorio4.routes.Routes
import com.pdm0126.savmlaboratorio4.screens.HomeScreen
import com.pdm0126.savmlaboratorio4.screens.TasksScreen

@Composable
fun TaskApp(modifier: Modifier = Modifier) {
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(backStack = backstack, onBack = {
        backstack.removeLastOrNull()
    }, entryProvider = entryProvider {
        entry<Routes.Home> {
            HomeScreen(navigateToTask = {
                backstack.add(Routes.Task)
            })
        }
        entry<Routes.Task> {
            TasksScreen()
        }
    })


}