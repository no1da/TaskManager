package bySharko.TaskManager.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
@Schema(description = "Сущность параметров аутентификации пользователя")
public class AuthenticationDTO {
    @NotNull(message = "Имя не должно быть пустым")
    @Schema(description = "Имя пользователя")
    private String name;
    @NotNull(message = "Укажите email")
    @Email
    @Schema(description = "Email пользователя")
    private String email;
    @NotNull(message = "Укажите пароль")
    @Schema(description = "Пароль пользователя")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
