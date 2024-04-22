package bySharko.TaskManager.controllers;

import bySharko.TaskManager.models.Status;
import bySharko.TaskManager.services.StatusService;
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
@RequestMapping("/status")
@Tag(name = "Контроллер Статуса", description = "Позволят получать перечень статусов, и вызывает статус по ID")
public class StatusController {
    private final StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    @Operation(summary = "Получение перечня статусов", description = "Позволяет получить перечень из всех возможных статусов")
    public List<Status> getAll() {
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение статуса", description = "Позволяет получить конкретный статус по ID")
    public Status getById(@PathVariable("id") @Parameter(description = "Идентификатор статуса") int id) {
        return statusService.getById(id);
    }
}
