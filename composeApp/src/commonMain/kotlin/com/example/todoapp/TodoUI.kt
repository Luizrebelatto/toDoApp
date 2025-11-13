package com.example.todoapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoApp(viewModel: TodoViewModel) {
    var newTodo by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.todos.size) { index ->
                val todo = viewModel.todos[index]
                TodoItem(
                    todo = todo,
                    onToggle = { viewModel.toggleDone(todo) },
                    onRemove = { viewModel.removeTodo(todo) }
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(
                value = newTodo,
                onValueChange = { newTodo = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                placeholder = { Text("Digite uma tarefa...") },
                singleLine = true
            )

            Button(
                onClick = {
                    if (newTodo.isNotBlank()) {
                        viewModel.addTodo(newTodo)
                        newTodo = ""
                    }
                },
                enabled = newTodo.isNotBlank()
            ) {
                Text("Adicionar")
            }
        }
    }
}

@Composable
fun TodoItem(todo: Todo, onToggle: () -> Unit, onRemove: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.isDone,
            onCheckedChange = { onToggle() }
        )
        Text(
            text = todo.title,
            modifier = Modifier.weight(1f).padding(start = 8.dp)
        )
        TextButton(onClick = onRemove) {
            Text("Remover")
        }
    }
}