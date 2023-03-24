package com.esprit.exam.controllers;


import com.esprit.exam.entities.Project;
import com.esprit.exam.repositories.ProjectRepository;
import com.esprit.exam.services.IProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectServices iProjectServices;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/")
    public List<Project> getAllPojects(){return iProjectServices.retrieveAll();}

    @GetMapping("/")
    public Project getProject(@PathVariable int id){return iProjectServices.retrieveProject(id);}

    @PostMapping("/")
    public Project createProject(@RequestBody Project project) {return iProjectServices.addProject(project);}

    @PutMapping
    public Project updateProject(@RequestBody Project project){return iProjectServices.updateProject(project);}

    @DeleteMapping
    public void deleteProject(@PathVariable int id){iProjectServices.removeProject(id);}
}
