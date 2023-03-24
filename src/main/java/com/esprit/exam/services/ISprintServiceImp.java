package com.esprit.exam.services;


import com.esprit.exam.entities.Sprint;
import com.esprit.exam.repositories.SprintRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ISprintServiceImp implements ISprintServices{

    SprintRepository sprintRepository;
    @Override
    public List<Sprint> retrieveAll() {
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
}
