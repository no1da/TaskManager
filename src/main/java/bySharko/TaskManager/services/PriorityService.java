package bySharko.TaskManager.services;

import bySharko.TaskManager.models.Priority;
import bySharko.TaskManager.models.Status;
import bySharko.TaskManager.repositories.PeopleRepository;
import bySharko.TaskManager.repositories.PriorityRepository;
import bySharko.TaskManager.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;

    @Autowired
    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> getAll(){
        return priorityRepository.findAll();
    }

    public Priority getById(int id){
        return priorityRepository.findById(id).get();
    }
}
