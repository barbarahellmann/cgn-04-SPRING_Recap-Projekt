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

    public Todo getTodoById(String id) {
        Todo temp = repo.findById(id).orElseThrow();
        return new Todo(
                temp.id(),
                temp.description(),
                temp.status());

    }

    public void createNewTodo(Todo newTodo) {
        Todo temp = new Todo(
                IdService.generatedId(),
//                UUID.randomUUID().toString(),
                newTodo.description(),
                newTodo.status());
        repo.save(temp);
    }


    // siehe fehler im Controller
    public Todo updateTodo(Todo updatableTodo) {
        return repo.save(updatableTodo);
    }

    // siehe fehler im Controller
    public void deleteTodo(String id) {

    }
}
