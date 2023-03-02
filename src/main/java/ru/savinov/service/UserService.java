package ru.savinov.service;

import ru.savinov.models.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    User findUserById(int id);
    void saveUserByUser(User user);
    void updateUserByUserAndId(User user, int id);
    void deleteUserById(int id);
}
