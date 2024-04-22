package bySharko.TaskManager.controllers;


import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "Контроллер пользователей", description = "Позволят получать список пользователей, и вызывает пользователя по ID")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController( PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение пользователя", description = "Позволяет получить пользователя по ID")
    public Person getById(@PathVariable("id") @Parameter(description = "Идентификатор пользователя") int id) {
        return personService.getById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Получение пользователей", description = "Позволяет получить всех пользователей")
    public List<Person> findAll() {
        return personService.findAll();
    }
}
