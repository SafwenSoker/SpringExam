package com.esprit.exam.services;

import com.esprit.exam.entities.Project;
import com.esprit.exam.entities.User;

import java.util.List;

public interface IProjectServices {
    public List<Project> retrieveAll();
    public Project updateProject(Project project);
    public Project addProject(Project project);
    public Project retrieveProject(int id);
    public void removeProject(int id);
}
