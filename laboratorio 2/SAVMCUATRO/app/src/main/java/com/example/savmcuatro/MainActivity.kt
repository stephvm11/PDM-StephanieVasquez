package com.example.savmcuatro

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savmcuatro.ui.theme.SAVMCUATROTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SAVMCUATROTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Listado(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Listado(modifier: Modifier = Modifier) {
    val listado = remember { mutableStateListOf<String>() }
    val nombre = remember { mutableStateOf("") }

    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize().padding(paddingValues)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f), contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = nombre.value,
                        onValueChange = {
                            nombre.value = it
                        },
                        modifier = Modifier.fillMaxWidth().padding(top=10.dp),
                        maxLines = 1,
                        minLines = 1,
                        singleLine = true,
                        placeholder = { Text("Nombre") },
                        isError = false,
                        keyboardActions = KeyboardActions(
                            onNext = {},
                            onDone = {},
                            onGo = {},
                            onPrevious = {},
                            onSearch = {},
                            onSend = {}
                        )
                    )
                    Button(
                        onClick = {
                            if (nombre.value.isNotBlank()) {
                                listado.add(nombre.value)
                                nombre.value = ""
                            }
                        },
                        modifier = Modifier.padding(top = 8.dp)
                    ) { Text(text = "Guardar") }
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f), contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Listado de nombres y posición en la lista",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.weight(1f).padding(end = 35.dp)
                    )
                    Button(
                        onClick = {
                            listado.clear()
                        }
                    ) { Text("Limpiar") }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(3.dp, Color.Blue, RoundedCornerShape(5.dp)).weight(4f)
                    .background(Color.White, RoundedCornerShape(5.dp)),
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(listado) { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = item
                            )
                            Text(
                                text = (index + 1).toString()
                            )
                        }
                    }
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListadoPreview() {
    SAVMCUATROTheme {
        Listado()
    }
}