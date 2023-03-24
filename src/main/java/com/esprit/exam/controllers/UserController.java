package com.esprit.exam.controllers;


import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.User;
import com.esprit.exam.repositories.UserRepository;
import com.esprit.exam.services.IUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserServices iUserServices;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers(){return iUserServices.retrieveAll();}

    @GetMapping("/")
    public User getUser(@PathVariable int id){return iUserServices.retrieveUser(id);}

    @PostMapping("/")
    public User createUser(@RequestBody User user) {return iUserServices.addUser(user);}

    @PutMapping
    public User updateUser(@RequestBody User user){return iUserServices.updateUser(user);}

    @DeleteMapping
    public void deleteUser(@PathVariable int id){iUserServices.removeUser(id);}
}
