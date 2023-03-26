package com.esprit.exam.repositories;

import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findAllBySprintsStartDateLessThan(Date date);
    List<Project> findAllByUsersRoleAndUsersFnameAndUsersLname(Role role, String fname, String lname);
}
