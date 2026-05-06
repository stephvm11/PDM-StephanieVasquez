package com.pdm0126.savmlaboratorio3.components

import android.hardware.Sensor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun GyroscopeSensor(navigateToBack: () -> Unit) {
    val gyroscopeValues = useSensor(Sensor.TYPE_GYROSCOPE)

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Giroscopio", fontSize = 24.sp, fontWeight = FontWeight.Bold
            )
            Text(
                text = "X:${gyroscopeValues[0]}", fontSize = 18.sp
            )
            Text(
                text = "Y:${gyroscopeValues[1]}", fontSize = 18.sp
            )
            Text(
                text = "Z:${gyroscopeValues[2]}", fontSize = 18.sp
            )

            Button(onClick = {
                navigateToBack()
            }) {
                Text(
                    text = "Volver"
                )
            }

        }
    }
}