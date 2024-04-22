package bySharko.TaskManager.services;

import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.repositories.PeopleRepository;
import bySharko.TaskManager.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class PersonService {
    private final PeopleRepository peopleRepository;
    private final PersonValidator personValidator;

    @Autowired
    public PersonService(PeopleRepository peopleRepository, PersonValidator personValidator) {
        this.peopleRepository = peopleRepository;
        this.personValidator = personValidator;
    }

    @Transactional
    public Person getById(int id) {
       return peopleRepository.findById(id).get();
    }
    @Transactional
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }
    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }
/*    @Transactional
    public Person findByName(String email){
        return peopleRepository.findByEmail(email);
    }*/

}
