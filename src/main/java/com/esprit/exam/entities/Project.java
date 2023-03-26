package com.esprit.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy="project",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Sprint> sprints;

    @ManyToMany(mappedBy="projects")
    @JsonIgnore
    private List<User> users;

}
