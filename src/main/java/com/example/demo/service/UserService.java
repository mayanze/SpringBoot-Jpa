package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUserByPage(int page, int size);

    List<User> getAll();

    User getById(int id);
}
