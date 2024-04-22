package bySharko.TaskManager.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Task Manager Api",
                description = "TaskManager", version = "1.0.0",
                contact = @Contact(
                        name = "Sharko Maksim",
                        email = "maksimshark291@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
