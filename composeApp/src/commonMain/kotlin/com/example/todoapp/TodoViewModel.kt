package com.example.todoapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TodoViewModel {
    private val todosItem = mutableStateListOf<Todo>()
    val todos: List<Todo> get() = todosItem

    fun addTodo(title: String) {
        if (title.isNotBlank()) {
            todosItem.add(Todo(id = todosItem.size + 1, title = title))
        }
    }

    fun removeTodo(todo: Todo) {
        todosItem.remove(todo)
    }

    fun toggleDone(todo: Todo) {
        val index = todosItem.indexOf(todo)
        if (index != -1) {
            todosItem[index] = todosItem[index].copy(isDone = !todosItem[index].isDone)
        }
    }
}
