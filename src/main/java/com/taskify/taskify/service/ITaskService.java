package com.taskify.taskify.service;

import com.taskify.taskify.model.Task;
import java.util.List;

// CRUD methods
public interface ITaskService {
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deteleTask(Long id);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
}
