package bySharko.TaskManager.repositories;

import bySharko.TaskManager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByName(String name);

    Optional<Person> findByEmail(String name);

    Person getByEmail(String email);
}
