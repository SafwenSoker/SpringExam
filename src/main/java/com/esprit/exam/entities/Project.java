package com.esprit.exam.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @OneToMany(mappedBy="project")
    private List<Sprint> sprints;

    @ManyToMany(mappedBy="projects")
    private List<User> users;

}
