package com.pdm0126.savmlaboratorio6.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.pdm0126.savmlaboratorio6.data.model.Meal

@Composable
fun CardMeal(meal: Meal) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp).height(120.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = meal.imageUrl,
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(120.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    text = meal.name, fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Categoria: ${meal.category}"
                )
                Text(
                    text = "Origen: ${meal.country}"
                )
            }
        }
    }
}