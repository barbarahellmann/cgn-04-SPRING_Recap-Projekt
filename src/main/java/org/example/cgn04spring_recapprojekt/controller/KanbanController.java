package org.example.cgn04spring_recapprojekt.controller;


import lombok.RequiredArgsConstructor;
import org.example.cgn04spring_recapprojekt.service.TodoService;
import org.example.cgn04spring_recapprojekt.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class KanbanController {

    private final TodoService service;

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }


    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return service.getTodoById(id);
    }

    @PostMapping
    public void createNewTodo(@RequestBody Todo newTodo) {
        service.createNewTodo(newTodo);
    }

// klappt nicht, keine Ahnung warum. Inhalt wird nicht aktualisiert.
    @PutMapping()
    public Todo updateTodo(@RequestBody Todo updatableTodo) {
        return service.updateTodo(updatableTodo);
    }

    // klappt nicht
    @DeleteMapping("/remove/{id}")
    public String deleteTodo(@PathVariable String id) {
        return "Todo with ID " + id + " removed successfully.";
    }
}