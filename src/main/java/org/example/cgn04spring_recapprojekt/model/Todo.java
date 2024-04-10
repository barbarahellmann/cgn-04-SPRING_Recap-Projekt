package org.example.cgn04spring_recapprojekt.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Todo")
public record Todo(String id, String description, Status status) {
}
