package com.pdm0126.savmlaboratorio3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {
    @Serializable
    data object Home : Routes() {

    }

    @Serializable
    data object Sensor : Routes() {
    }

    @Serializable
    data object List : Routes() {
    }
}