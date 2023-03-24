package com.esprit.exam.services;

import com.esprit.exam.entities.User;

import java.util.List;

public interface IUserServices {
    public List<User> retrieveAll();
    public User updateUser(User user);
    public User addUser(User user);
    public User retrieveUser(int id);
    public void removeUser(int id);
}
