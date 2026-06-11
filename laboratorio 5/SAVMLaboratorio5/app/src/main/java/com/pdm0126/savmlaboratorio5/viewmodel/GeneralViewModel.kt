package com.pdm0126.savmlaboratorio5.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.pdm0126.savmlaboratorio5.SavmLaboratorio5Aplication
import com.pdm0126.savmlaboratorio5.data.model.Task
import com.pdm0126.savmlaboratorio5.data.repository.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date

class GeneralViewModel(private val taskRepository: TaskRepository) : ViewModel() {
    val tasks: StateFlow<List<Task>> = taskRepository.getTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(task: Task) {
        viewModelScope.launch {
            taskRepository.addTask(task)
        }
    }
    fun deleteTask(task: Task){
        viewModelScope.launch {
            taskRepository.deleteTask(task)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            initializer{
                val app = this[APPLICATION_KEY] as SavmLaboratorio5Aplication
                GeneralViewModel(app.appProvider.provideTaskRepository())
            }

        }
    }
}