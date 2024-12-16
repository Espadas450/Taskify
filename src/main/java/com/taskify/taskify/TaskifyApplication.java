package com.taskify.taskify;

import com.taskify.taskify.Repository.TaskRepository;
import com.taskify.taskify.model.Task;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskifyApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(TaskRepository taskRepository) {
		return args -> {
			// Test Task
			taskRepository.save(new Task(1L, "Test Task 1", "Description 1", "Pending"));
			taskRepository.save(new Task(2L, "Test Task 2", "Description 2", "Completed"));
			System.out.println("Tasks initialized in the database.");
		};
		}
}
