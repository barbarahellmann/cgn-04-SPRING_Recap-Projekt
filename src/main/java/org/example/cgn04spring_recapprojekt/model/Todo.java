package org.example.cgn04spring_recapprojekt.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Todo")
public record Todo(@Id String id, String description, Status status) {
}
