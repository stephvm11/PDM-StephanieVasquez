package com.pdm0126.savmlaboratorio6.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{
    @Serializable
    data object Home : Routes()
}