package ru.savinov.dao;

import ru.savinov.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(User user, int id);
    void delete(int id);
}
