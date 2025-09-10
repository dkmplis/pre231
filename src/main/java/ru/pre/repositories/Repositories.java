package ru.pre.repositories;

import ru.pre.model.User;

import java.util.List;

public interface Repositories {
    List<User> getAllUser();
    User getUserById(int id);
    void addNewUser(User user);
    void deleteById(int id);
    void update(int id, User updatedUser);
}
