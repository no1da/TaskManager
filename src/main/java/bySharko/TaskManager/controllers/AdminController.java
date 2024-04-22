package bySharko.TaskManager.controllers;


import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Контроллер администратора", description = "Создан для исключительно для проверки авторизации")
public class AdminController {
    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

}
