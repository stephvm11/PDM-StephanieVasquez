package com.pdm0126.savmlaboratorio5.data.repository

import com.pdm0126.savmlaboratorio5.data.database.dao.TaskDao
import com.pdm0126.savmlaboratorio5.data.database.entities.toEntity
import com.pdm0126.savmlaboratorio5.data.database.entities.toModel
import com.pdm0126.savmlaboratorio5.data.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl (
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun addTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }

    override suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task.toEntity())
    }
}