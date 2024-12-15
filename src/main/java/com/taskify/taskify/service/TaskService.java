package com.taskify.taskify.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskify.taskify.model.Task;

// Interface implementation
@Service
public class TaskService implements ITaskService {
    
    // Test List
    private final List<Task> taskList = new ArrayList<>();
    
    @Override
    public Task createTask(Task task) {
        task.setId((long) (taskList.size() + 1)); // id simulation
        taskList.add(task);
        return task;
    }
    
    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskList.stream()
                                        .filter(t -> t.getId().equals(id))
                                        .findFirst();

        if (existingTask.isPresent()){
            Task updatedTask = existingTask.get();

            updatedTask.SetTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());

            return updatedTask;

        }
        throw new RuntimeException("Task not found with id: " + id);
    }

    @Override
    public void deteleTask(Long id) {
        taskList.removeIf(task -> task.getId().equals(id));
    }
    
    @Override
    public Task getTaskById(Long id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
    
    @Override
    public List<Task> getAllTasks() {
        return new ArrayList<>(taskList);
    }
    
}
