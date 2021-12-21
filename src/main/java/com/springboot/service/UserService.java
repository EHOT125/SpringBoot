package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void createUser(User user);

    User findUserById(Long id);

    void updateUser(User user);

    void delete(Long id);
}
