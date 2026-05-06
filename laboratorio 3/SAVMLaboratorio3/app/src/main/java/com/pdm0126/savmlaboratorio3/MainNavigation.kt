package com.pdm0126.savmlaboratorio3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.savmlaboratorio3.components.GyroscopeSensor
import com.pdm0126.savmlaboratorio3.components.listadoNombre
import com.pdm0126.savmlaboratorio3.screens.HomeScreen

@Composable
fun sensorApp(modifier: Modifier) {
    val backstack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backstack,
        onBack = {
            backstack.removeLastOrNull()
        },
        entryProvider = entryProvider {
            entry <Routes.Home> {
                HomeScreen(navigateToList = {
                    backstack.add(Routes.List)
                }, navigateToSensor = {
                    backstack.add(Routes.Sensor)
                }
                )
            }
            entry <Routes.List>{
                listadoNombre(navigateToBack = {
                    backstack.removeLastOrNull()
                })
            }
            entry <Routes.Sensor>{
                GyroscopeSensor(navigateToBack = {
                    backstack.removeLastOrNull()
                })
            }
        }

    )
}