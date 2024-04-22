package bySharko.TaskManager.util;

import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class PersonValidator implements Validator {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PersonValidator(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        Optional<Person> person1 = peopleRepository.findByName(person.getName());
        if (person1.isPresent()) {
            throw new UsernameNotFoundException("IsPresent");
        }
    }

    public void validateByEmail(Person person) {
        Optional<Person> personOptional = peopleRepository.findByEmail(person.getEmail());
        if (personOptional.isPresent()) {
            throw new CustomException("Email занят");
        }
    }

}


