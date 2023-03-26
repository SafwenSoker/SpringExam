package com.esprit.exam.repositories;

import com.esprit.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByFnameAndLname(String fname, String lname);
}
