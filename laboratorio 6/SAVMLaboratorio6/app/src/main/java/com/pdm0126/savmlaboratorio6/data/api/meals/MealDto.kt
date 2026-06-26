package com.pdm0126.savmlaboratorio6.data.api.meals

import com.pdm0126.savmlaboratorio6.data.model.Meal
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealDto(
    @SerialName("idMeal") val id: String,
    @SerialName("strMeal") val name: String,
    @SerialName("strCategory") val category: String,
    @SerialName("strArea") val area: String?,
    @SerialName("strMealThumb") val imageUrl: String
)

fun MealDto.toModel(): Meal{
    return Meal(
        id = id,
        name = name,
        category = category,
        country = area,
        imageUrl = imageUrl
    )
}