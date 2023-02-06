package ru.savinov.service;

import ru.savinov.models.User;

import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User user, int id);
    void delete(int id);
}
