package com.example.todoapp

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class TodoViewModel {
    private val _todos = mutableStateListOf<Todo>()
    val todos: List<Todo> get() = _todos

    fun addTodo(title: String) {
        if (title.isNotBlank()) {
            _todos.add(Todo(id = _todos.size + 1, title = title))
        }
    }

    fun removeTodo(todo: Todo) {
        _todos.remove(todo)
    }

    fun toggleDone(todo: Todo) {
        val index = _todos.indexOf(todo)
        if (index != -1) {
            _todos[index] = _todos[index].copy(isDone = !_todos[index].isDone)
        }
    }
}
