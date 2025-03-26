package com.bootapp.springbootapp.service;

import com.bootapp.springbootapp.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getUsers();
    public void deleteUser(long id);
    public User getUserById(long id);
    public void editUser(User user);
}
