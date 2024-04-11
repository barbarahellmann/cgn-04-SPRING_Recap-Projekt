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

}
