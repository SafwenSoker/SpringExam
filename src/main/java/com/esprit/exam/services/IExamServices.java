package com.esprit.exam.services;

import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.Sprint;
import com.esprit.exam.entities.User;

import java.util.List;

public interface IExamServices {
    List<Project> retrieveAllProjects();
    Project updateProject(Project project);
    Project addProject(Project project) throws Exception;
    Project retrieveProject(int id);
    void removeProject(int id);

    List<Sprint> retrieveAllSprints();
    Sprint updateSprint(Sprint sprint);
    Sprint addSprint(Sprint sprint);
    Sprint retrieveSprint(Integer id);
    void removeSprint(Integer id);

    List<User> retrieveAllUsers();
    User updateUser(User user);
    User addUser(User user);
    User retrieveUser(int id);
    void removeUser(int id);

    void assignProjectToUser(int projectId, int userId);

    void assignProjectToClient(int projectId, String fname, String lname);

    List<Project> getAllCurrentProjects();

    List<Project> getProjectsByScrumMaster(String fname, String lname);

    Sprint addSprintAndAssignToProject(Sprint sprint, int idProject);
}
