package org.example.cgn04spring_recapprojekt.controller;


import lombok.RequiredArgsConstructor;
import org.example.cgn04spring_recapprojekt.service.TodoService;
import org.example.cgn04spring_recapprojekt.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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


    // klappt. Yay. Im Postman getestet
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable String id) {
        try {
            service.deleteTodo(id).orElseThrow();
            return "Todo not deleted";
        } catch (NoSuchElementException e) {
            return "Todo successfully deleted";
        }
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@RequestBody Todo requiredTodo) {
        return service.updateTodo(requiredTodo);
    }
}