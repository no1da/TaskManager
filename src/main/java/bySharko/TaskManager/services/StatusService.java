package bySharko.TaskManager.services;

import bySharko.TaskManager.models.Status;
import bySharko.TaskManager.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getAll(){
        return statusRepository.findAll();
    }

    public Status getById(int id){
        return statusRepository.findById(id).get();
    }
}
