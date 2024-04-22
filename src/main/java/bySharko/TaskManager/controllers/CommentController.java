package bySharko.TaskManager.controllers;

import bySharko.TaskManager.dto.CommentDTO;
import bySharko.TaskManager.services.CommentService;
import bySharko.TaskManager.util.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Tag(name = "Контроллер сообщений", description = "Позволят получать, создавать и удалять сообщения к задачам")
public class CommentController {
    private final CommentService commentService;


    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}/comment")
    @Operation(summary = "Получение сообщений", description = "Позволяет получить сообщения к конкретной задачи по ID")
    public List<CommentDTO> getById(@PathVariable("id") @Parameter(description = "Идентификатор задачи") int id) {
        return commentService.getById(id);
    }

    @PostMapping("/{id}/comment")
    @Operation(summary = "Создание сообщения", description = "Позволяет создать сообщение к конкретной задачи по ID")
    public void save(@RequestBody CommentDTO comment, @PathVariable("id") @Parameter(description = "Идентификатор задачи") int id,
                     Authentication authentication) {
        commentService.save(comment, authentication, id);
    }

    @DeleteMapping("/comment/{id}")
    @Operation(summary = "Удаление сообщения", description = "Позволяет удалить конкретное сообщение")
    public void delete(@PathVariable("id") @Parameter(description = "Идентификатор сообщения") int id) {
        commentService.delete(id);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> onConstraintValidationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
    }
}
