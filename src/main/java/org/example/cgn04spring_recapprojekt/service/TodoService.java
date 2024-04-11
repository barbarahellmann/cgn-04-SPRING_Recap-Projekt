package org.example.cgn04spring_recapprojekt.service;

import lombok.RequiredArgsConstructor;
import org.example.cgn04spring_recapprojekt.model.Todo;
import org.example.cgn04spring_recapprojekt.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TodoService {


    private final TodoRepository repo;

    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

    public Todo getTodoById(String id) {
        Todo temp = repo.findById(id).orElseThrow();
        return new Todo(
                temp.getId(),
                temp.getDescription(),
                temp.getStatus());

    }

    public void createNewTodo(Todo newTodo) {
        Todo temp = new Todo(
                IdService.generatedId(),
//                UUID.randomUUID().toString(),
                newTodo.getDescription(),
                newTodo.getStatus());
        repo.save(temp);
    }

    public Optional<Todo> deleteTodo(String id) {
        repo.delete(repo.findById(id).orElseThrow());
        return repo.findById(id);
    }

    public Todo updateTodo(Todo requiredTodo) {
        Todo temp2 = repo.findById(requiredTodo.getId()).orElseThrow();
        repo.save(temp2.withStatus(requiredTodo.getStatus()).withDescription(requiredTodo.getDescription()));
        return repo.findById(temp2.getId()).orElseThrow();
    }
}