package com.pdm0126.savmlaboratorio6.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.savmlaboratorio6.data.model.Meal
import com.pdm0126.savmlaboratorio6.data.repository.MealRepository
import com.pdm0126.savmlaboratorio6.data.repository.MealRespositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel(
    private val repository: MealRepository = MealRespositoryImpl()
) : ViewModel() {

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun loadMeals() {
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null
            repository.getMeals()
                .onSuccess { _meals.value = it }
                .onFailure { _error.value = "Ha ocurrido un error." }
            _isLoading.value = false
        }
    }
}