package com.pdm0126.savmlaboratorio6.data.repository

import com.pdm0126.savmlaboratorio6.data.model.Meal

interface MealRepository {
    suspend fun getMeals(): Result<List<Meal>>
}