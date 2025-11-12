package com.example.todoapp.todo

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TodoViewModel {
    private val _todos = MutableStateFlow<List<Todo>>(emptyList())
    val todos: StateFlow<List<Todo>> = _todos

    private var nextId = 0

    fun addTodo(title: String) {
        if (title.isBlank()) return
        val newTodo = Todo(id = nextId++, title = title)
        _todos.value = _todos.value + newTodo
    }

    fun toggleTodo(id: Int) {
        _todos.value = _todos.value.map {
            if (it.id == id) it.copy(isDone = !it.isDone) else it
        }
    }

    fun removeTodo(id: Int) {
        _todos.value = _todos.value.filterNot { it.id == id }
    }
}
