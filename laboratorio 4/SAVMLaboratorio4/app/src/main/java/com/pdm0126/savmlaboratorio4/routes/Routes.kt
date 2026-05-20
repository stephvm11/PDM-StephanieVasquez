package com.pdm0126.savmlaboratorio4.routes

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home: Routes()
@Serializable
data object Task: Routes()
}