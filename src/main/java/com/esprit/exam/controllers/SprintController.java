package com.esprit.exam.controllers;


import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.Sprint;
import com.esprit.exam.repositories.SprintRepository;
import com.esprit.exam.services.ISprintServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private ISprintServices iSprintServices;

    @Autowired
    private SprintRepository sprintRepository;

    @GetMapping("/")
    public List<Sprint> getAllSprints(){return iSprintServices.retrieveAll();}

    @GetMapping("/")
    public Sprint getSprint(@PathVariable int id){return iSprintServices.retrieveSprint(id);}

    @PostMapping("/")
    public Sprint createSprint(@RequestBody Sprint sprint) {return iSprintServices.addSprint(sprint);}

    @PutMapping
    public Sprint updateSprint(@RequestBody Sprint sprint){return iSprintServices.updateSprint(sprint);}

    @DeleteMapping
    public void deleteSprint(@PathVariable int id){ iSprintServices.removeSprint(id);}
}
