package org.example.cgn04spring_recapprojekt.service;

import java.util.UUID;

public class IdService {

    public static String generatedId() {
        return UUID.randomUUID().toString();
    }
}
