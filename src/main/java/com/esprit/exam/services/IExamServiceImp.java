package com.esprit.exam.services;


import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.Role;
import com.esprit.exam.entities.Sprint;
import com.esprit.exam.entities.User;
import com.esprit.exam.repositories.ProjectRepository;
import com.esprit.exam.repositories.SprintRepository;
import com.esprit.exam.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IExamServiceImp implements IExamServices{

    private final UserRepository userRepository;
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    @Override
    public List<Project> retrieveAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Project addProject(Project project) throws Exception {
        if(project.getSprints() == null || project.getSprints().size() == 0){
            throw new Exception("You must provide at least provide one sprint");
        }
        projectRepository.saveAndFlush(project);
        project.getSprints().forEach((s) -> {
            s.setProject(project);
        });
        return project;
    }

    @Override
    public Project retrieveProject(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void removeProject(int id) {
        projectRepository.deleteById(id);
    }
    @Override
    public List<Sprint> retrieveAllSprints() {
        return sprintRepository.findAll();
    }

    @Override
    public Sprint updateSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    @Override
    public Sprint retrieveSprint(Integer id) {
        return sprintRepository.findById(id).orElse(null);
    }

    @Override
    public void removeSprint(Integer id) {
        sprintRepository.deleteById(id);
    }
    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User retrieveUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void assignProjectToUser(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        Assert.notNull(user, "User must be not null");
        Assert.notNull(project, "Project must be not null");
        user.getProjects().add(project);
        user.setProjects(user.getProjects());
    }

    @Override
    @Transactional
    public void assignProjectToClient(int projectId, String fname, String lname) {
        Project project = projectRepository.findById(projectId).orElse(null);
        User client = userRepository.findByFnameAndLname(fname, lname).orElse(null);
        Assert.notNull(client, "User must be not null");
        Assert.notNull(project, "Project must be not null");
        client.getClient_projects().add(project);
        client.setClient_projects(client.getClient_projects());
    }

    @Override
    public List<Project> getAllCurrentProjects() {
        Date date = new Date();
        return projectRepository.findAllBySprintsStartDateLessThan(date);
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fname, String lname) {
        return projectRepository.findAllByUsersRoleAndUsersFnameAndUsersLname(Role.SCRUM_MASTER,fname, lname);
    }

    @Override
    public Sprint addSprintAndAssignToProject(Sprint sprint, int idProject) {
        Project project = projectRepository.findById(idProject).orElse(null);
        Assert.notNull(project, "Project not found");
        sprint.setProject(project);
        sprintRepository.saveAndFlush(sprint);
        return sprint;
    }
    @Scheduled(fixedRate = 30000)
    @Override
    public void getNbrSprintByCurrentProject() {

        List<Project> projects = this.getAllCurrentProjects();
        projects.forEach((p)-> {
            System.out.println("Project "+p.getTitle() + " have " + p.getSprints().size() + " sprints");
        });
    }

}
