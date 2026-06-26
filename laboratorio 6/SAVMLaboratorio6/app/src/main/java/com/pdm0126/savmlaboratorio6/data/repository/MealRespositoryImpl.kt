package com.pdm0126.savmlaboratorio6.data.repository

import com.pdm0126.savmlaboratorio6.data.api.KtorClient
import com.pdm0126.savmlaboratorio6.data.api.meals.MealDto
import com.pdm0126.savmlaboratorio6.data.api.meals.toModel
import com.pdm0126.savmlaboratorio6.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    @SerialName("meals") val meals: List<MealDto>
)

class MealRespositoryImpl : MealRepository {
    override suspend fun getMeals(): Result<List<Meal>> {
        return try {
            val response = KtorClient.client
                .get("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<MealResponse>()

            val meals = response.meals.map { it.toModel() }
            Result.success(meals)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}