package com.pdm0126.savmlaboratorio5

import android.app.Application
import com.pdm0126.savmlaboratorio5.data.AppProvider

class SavmLaboratorio5Aplication: Application() {
    val appProvider by lazy { AppProvider(this) }
}