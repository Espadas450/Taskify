package com.taskify.taskify.service;

import java.util.List;
import java.util.Optional;

import com.taskify.taskify.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import com.taskify.taskify.model.Task;

// Interface implementation
@Service
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;

    // Dependency Injection con TaskRepository
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskRepository.findById(id).map(existingTask ->{
            // Update attributes.
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());

            // Save changes.
            return taskRepository.save(existingTask);
        })
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
        taskRepository.delete(task);
    }


    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    
}