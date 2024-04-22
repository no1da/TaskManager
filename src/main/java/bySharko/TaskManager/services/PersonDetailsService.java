package bySharko.TaskManager.services;

import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.repositories.PeopleRepository;
import bySharko.TaskManager.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException{
        Optional<Person> person = peopleRepository.findByName(s);
        if (person.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new PersonDetails(person.get());
    }
}
