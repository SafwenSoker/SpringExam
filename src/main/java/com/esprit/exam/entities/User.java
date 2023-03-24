package com.esprit.exam.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String pwd;
    private String fname;
    private String lname;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private List<Project> projects;

    @OneToMany
    private List<Project> client_projects;


}
