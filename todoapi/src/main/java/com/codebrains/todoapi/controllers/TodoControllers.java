package com.codebrains.todoapi.controllers;

import com.codebrains.todoapi.entities.Todo;
import com.codebrains.todoapi.entities.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoControllers {

    private final TodoRepository todoRepository;

    public TodoControllers(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;

    }

    @PostMapping
    public Todo newTodo(@RequestBody Todo todo) {
        return this.todoRepository.save(todo);
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") Long todoId) {
        var todo = todoRepository.findById(todoId);
        return todo;
    }

    @PutMapping("/{todoId}")
    public Optional<Todo> updateTodo(@PathVariable("todoId") Long todoId, @RequestBody Todo updateTodo) {
        return this.todoRepository.findById(todoId).map(oldTodo -> this.todoRepository.save(updateTodo));
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        this.todoRepository.deleteById(todoId);

    }

}
