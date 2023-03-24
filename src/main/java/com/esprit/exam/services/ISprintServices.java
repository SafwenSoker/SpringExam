package com.esprit.exam.services;

import com.esprit.exam.entities.Sprint;
import com.esprit.exam.entities.User;

import java.util.List;

public interface ISprintServices {
    public List<Sprint> retrieveAll();
    public Sprint updateSprint(Sprint sprint);
    public Sprint addSprint(Sprint sprint);
    public Sprint retrieveSprint(Integer id);
    public void removeSprint(Integer id);
}
