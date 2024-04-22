package bySharko.TaskManager.controllers;

import bySharko.TaskManager.models.Priority;
import bySharko.TaskManager.services.PriorityService;
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
@RequestMapping("/priority")
@Tag(name = "Контроллер Приоритета", description = "Позволят получать перечень приоритетов, и вызывает приоритет по ID")
public class PriorityController {
    private final PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping
    @Operation(summary = "Получение перечня приоритетов", description = "Позволяет получить перечень из всех возможных приоритетов")
    public List<Priority> getAll() {
        return priorityService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение приоритета", description = "Позволяет получить конкретный приоритет по ID")
    public Priority getById(@PathVariable("id") @Parameter(description = "Идентификатор приоритета") int id) {
        return priorityService.getById(id);
    }
}
