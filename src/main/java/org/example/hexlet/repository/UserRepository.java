package org.example.hexlet.repository;

import org.example.hexlet.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User(1L, "Pearl", "pearl@example.com", "password", LocalDateTime.now()));
    }

    public static List<User> getEntities() {
        return USERS;
    }

    public static Optional<User> find(Long id) {
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
