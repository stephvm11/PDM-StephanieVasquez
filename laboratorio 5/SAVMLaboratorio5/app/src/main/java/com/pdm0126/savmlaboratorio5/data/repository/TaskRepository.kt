package com.pdm0126.savmlaboratorio5.data.repository

import com.pdm0126.savmlaboratorio5.data.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun getTasks(): Flow<List<Task>>
    suspend fun addTask(task: Task)
    suspend fun deleteTask(task: Task)
}