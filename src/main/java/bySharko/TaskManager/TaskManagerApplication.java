package bySharko.TaskManager;

import bySharko.TaskManager.security.JWTUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Bean
	public JWTUtil jwtUtil(){
		return new JWTUtil();
	}

}
