package com.unir.users.service;

import com.unir.users.model.pojo.User;
import com.unir.users.model.request.CreateUserRequest;

import java.util.List;

public interface UsersService {
    List<User> getUsers();
    User getUser(String userId);
    User addUser(CreateUserRequest request);
    User updateUser(Long userId, CreateUserRequest request);
    Boolean deleteUser(Long userId);
}
