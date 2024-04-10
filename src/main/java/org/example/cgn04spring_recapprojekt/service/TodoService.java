package org.example.cgn04spring_recapprojekt.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.RequiredArgsConstructor;
import org.example.cgn04spring_recapprojekt.model.Todo;
import org.example.cgn04spring_recapprojekt.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;


@RequiredArgsConstructor
@Service
public class TodoService {


    private final TodoRepository repo;


    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

//    public Todo gettodoById(String id) {
//        Todo temp = repo.findById(id).orElseThrow();
//        return new Todo(
//                temp.id());
//
//    }
//
    public void createNewTodo(Todo newTodo) {
        Todo temp = new Todo(
                UUID.randomUUID().toString(),
                newTodo.description(),
                newTodo.status());
        repo.save(temp);
    }
}