package com.esprit.exam.services;

import com.esprit.exam.entities.User;
import com.esprit.exam.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImp implements IUserServices{


    UserRepository userRepository;
    @Override
    public List<User> retrieveAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User retrieveUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }
}