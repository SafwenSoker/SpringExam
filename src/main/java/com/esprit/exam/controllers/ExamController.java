package com.esprit.exam.controllers;


import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.Sprint;
import com.esprit.exam.entities.User;
import com.esprit.exam.services.IExamServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name ="Exam Controller")
@RestController
@RequestMapping("/")
public class ExamController {

    @Autowired
    private IExamServices iExamServices;


    @GetMapping("/projects")
    public List<Project> getAllPojects(){return iExamServices.retrieveAllProjects();}

    @GetMapping("/projects/{id}")
    public Project getProject(@PathVariable int id){return iExamServices.retrieveProject(id);}

    @PostMapping("/projects")
    public Project createProject(@RequestBody Project project) throws Exception {return iExamServices.addProject(project);}

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project){return iExamServices.updateProject(project);}

    @DeleteMapping("/projects/{id}")
    public void deleteProject(@PathVariable int id){iExamServices.removeProject(id);}

    @GetMapping("/sprints")
    public List<Sprint> getAllSprints(){return iExamServices.retrieveAllSprints();}

    @GetMapping("/sprints/{id}")
    public Sprint getSprint(@PathVariable int id){return iExamServices.retrieveSprint(id);}

    @PostMapping("/sprints")
    public Sprint createSprint(@RequestBody Sprint sprint) {return iExamServices.addSprint(sprint);}

    @PutMapping("/sprints")
    public Sprint updateSprint(@RequestBody Sprint sprint){return iExamServices.updateSprint(sprint);}

    @DeleteMapping("/sprints/{id}")
    public void deleteSprint(@PathVariable int id){ iExamServices.removeSprint(id);}

    @GetMapping("/users")
    public List<User> getAllUsers(){return iExamServices.retrieveAllUsers();}

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){return iExamServices.retrieveUser(id);}

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {return iExamServices.addUser(user);}

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){return iExamServices.updateUser(user);}

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){iExamServices.removeUser(id);}

    @PutMapping("/assignProjectUser/{projectId}/{userId}")
    public void assignProjectToUser(@PathVariable int projectId, @PathVariable int userId){
        iExamServices.assignProjectToUser(projectId,userId);
    }

    @PutMapping("/assignProjectClient/{projectId}/{fname}/{lname}")
    public void assignProjectToClient(@PathVariable int projectId, @PathVariable String fname,@PathVariable String lname){
        iExamServices.assignProjectToClient(projectId,fname,lname);
    }

    @GetMapping("/projects/now")
    public List<Project> getAllCurrentProjects(){
        return iExamServices.getAllCurrentProjects();
    }

    @GetMapping("/projects/scrum_master/{fname}/{lname}")
    public List<Project> getProjectsByScrumMaster(@PathVariable String fname, @PathVariable String lname){
        return iExamServices.getProjectsByScrumMaster(fname, lname);
    }

    @PostMapping("/sprints/assign_project/{id}")
    public Sprint addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable int id){
        return iExamServices.addSprintAndAssignToProject(sprint, id);
    }

}
