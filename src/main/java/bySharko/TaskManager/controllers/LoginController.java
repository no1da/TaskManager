package bySharko.TaskManager.controllers;


import bySharko.TaskManager.dto.AuthenticationDTO;
import bySharko.TaskManager.models.Person;
import bySharko.TaskManager.repositories.PeopleRepository;
import bySharko.TaskManager.security.JWTUtil;
import bySharko.TaskManager.services.RegistrationService;
import bySharko.TaskManager.util.CustomException;
import bySharko.TaskManager.util.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Tag(name = "Контроллер доступа", description = "Позволят пользователям логиниться, регистрироваться")
public class LoginController {

    private final RegistrationService registrationService;
    private final JWTUtil jwtUtil;

    private final PeopleRepository peopleRepository;

    @Autowired
    public LoginController(RegistrationService registrationService, JWTUtil jwtUtil, PeopleRepository peopleRepository) {
        this.registrationService = registrationService;
        this.jwtUtil = jwtUtil;

        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/registration")
    @Operation(summary = "Регистрация пользователя", description = "Позволяет осуществить регистрацию в приложении")
    public Map<String, String> registration(@RequestBody Person person) {
        registrationService.register(person);
        String token = jwtUtil.generateToken(person.getName());
        return Map.of("jwt-token", token);
    }

    @PostMapping("/login")
    @Operation(summary = "Авторизация пользователя", description = "Позволяет осуществить вход в приложение(аутентификацию, авторизацию)")
    public Map<String, String> performLogin(@RequestBody AuthenticationDTO authenticationDTO) {
        Optional<Person> person = peopleRepository.findByEmail(authenticationDTO.getEmail());
        if (person.isEmpty()) {
            throw new CustomException("Пользователь не найден");
        }
        Person personAuth = peopleRepository.getByEmail(authenticationDTO.getEmail());
        if (personAuth.getPassword().equals(authenticationDTO.getPassword()) & personAuth.getName().
                equals(authenticationDTO.getName())) {
            String token = jwtUtil.generateToken(authenticationDTO.getName());
            return Map.of("jwt-token", token);
        } else {
            /*return Map.of("message", "Incorrect credentials!");*/
            throw new CustomException("Неверные данные");
        }
    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(CustomException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(e.getMessage()));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> onConstraintValidationException(ConstraintViolationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(e.getMessage()));
    }

}
