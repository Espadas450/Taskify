package com.taskify.taskify.service;

import com.taskify.taskify.model.Task;
import java.util.List;
import java.util.Optional;

// CRUD methods
public interface ITaskService {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
}
