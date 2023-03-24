package com.esprit.exam.repositories;

import com.esprit.exam.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
