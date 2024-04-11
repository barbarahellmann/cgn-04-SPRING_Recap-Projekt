package org.example.cgn04spring_recapprojekt.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@RequiredArgsConstructor
@Document("Todo")
public class Todo {

    private final String id;
    @With
    private final String description;
    @With
    private final Status status;

//   @Document("Todo")
//    public class Todo(@Id String id, String description, Status status){
//    @Override
//    public String id() {
//        return id;
//    }
//
//    @Override
//    public String description() {
//        return description;
//    }
//
//    @Override
//    public Status status() {
//        return status;
//    }
//
//    @Override
//    public String getId() {
//        return id;
//    }
}
