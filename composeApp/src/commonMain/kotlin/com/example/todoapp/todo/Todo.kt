package com.example.todoapp.todo

data class Todo(
    val id: Int,
    val title: String,
    val isDone: Boolean = false
)
