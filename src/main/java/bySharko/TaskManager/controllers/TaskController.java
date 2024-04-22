package bySharko.TaskManager.controllers;

import bySharko.TaskManager.dto.TaskStateDTO;
import bySharko.TaskManager.services.TaskService;
import bySharko.TaskManager.util.CustomException;
import bySharko.TaskManager.util.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Tag(name = "Контроллер задач", description = "Позволят получать список задача, редактировать, удалять. Искать задачи на" +
        " исполнении и контроле")
public class TaskController {
    private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @Operation(summary = "Получение всех задач", description = "Позволяет получить все задачи всех пользователей")
    @GetMapping
    public List<TaskStateDTO> getAll() {
        return service.getAll();
    }

    @Operation(summary = "Получение задач на исполнение", description = "Позволяет получить все задачи которые необходимо выполнить")
    @GetMapping("/assignee")
    public List<TaskStateDTO> showAllOfAssignee(Authentication authentication) {
        return service.getByAssigneeId(authentication);
    }

    @Operation(summary = "Получение задач на контроль", description = "Позволяет получить все задачи которые вы поставили" +
            " другим пользователям")
    @GetMapping("/author")
    public List<TaskStateDTO> showAllOfAuthor(Authentication authentication) {
        return service.getByAuthorId(authentication);
    }

    @Operation(summary = "Создание задачи", description = "Позволяет создать задачу")
    @PostMapping
    public void save(@RequestBody TaskStateDTO taskStateDTO, Authentication authentication) {
        service.save(taskStateDTO, authentication);
    }

    @Operation(summary = "Редактирование задачи", description = "Позволяет отредактировать задачу")
    @PostMapping("/{id}")
    public void update(@RequestBody TaskStateDTO taskStateDTO, @PathVariable("id") @Parameter(description = "Идентификатор " +
            "пользователя") int id, Authentication authentication) {
        service.update(taskStateDTO, id, authentication);
    }

    @Operation(summary = "Удаление задачи", description = "Позволяет удалить задачу")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") @Parameter(description = "Идентификатор пользователя") int id, Authentication authentication) {
        service.delete(id, authentication);
    }

/*    @GetMapping("/showUser")
    @ResponseBody
    public String showUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getUsername();
    }*/

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(CustomException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }

}
