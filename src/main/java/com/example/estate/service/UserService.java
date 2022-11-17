package com.example.estate.service;

import com.example.estate.model.Role;
import com.example.estate.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    //All the usernames are gonna be unique
    User getUser(String username);
    Role getRole(String name);
    List<User>getUsers();
    List<Role>getRoles();

}
