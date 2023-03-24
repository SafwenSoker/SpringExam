package com.esprit.exam.services;


import com.esprit.exam.entities.Project;
import com.esprit.exam.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProjectServiceImp implements IProjectServices{


    ProjectRepository projectRepository;
    @Override
    public List<Project> retrieveAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project retrieveProject(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void removeProject(int id) {
        projectRepository.deleteById(id);
    }
}
