package bySharko.TaskManager.services;

import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.repositories.PeopleRepository;
import bySharko.TaskManager.util.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class RegistrationService {
    private final PeopleRepository peopleRepository;
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;
    private final PersonValidator personValidator;

    @Autowired
    public RegistrationService(PeopleRepository peopleRepository, PersonService personService, PasswordEncoder passwordEncoder, PersonValidator personValidator) {
        this.peopleRepository = peopleRepository;
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
        this.personValidator = personValidator;
    }

    @Transactional
    public void register(@Valid Person person) {
        personValidator.validateByEmail(person);
        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        person.setRole("ROLE_USER");
        personService.save(person);
    }

}
