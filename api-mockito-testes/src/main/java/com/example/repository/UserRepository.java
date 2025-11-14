package com.example.repository;

import com.example.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<Long, User> database = new HashMap<>();

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public User save(User user) {
        database.put(user.getId(), user);
        return user;
    }

    // Novo método delete
    public void delete(Long id) {
        database.remove(id);
    }
}
