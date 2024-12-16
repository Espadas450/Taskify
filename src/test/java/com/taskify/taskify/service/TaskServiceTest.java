package com.taskify.taskify.service;

import com.taskify.taskify.Repository.TaskRepository;
import com.taskify.taskify.model.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void createTaskSuccessfully() {
        // We generate 2 Task type instances to test them.
        Task taskError = new Task(2L, "Wrong title", "Bad description", "Completed");
        Task taskOK = new Task(1L, "Test title", "Test description", "Pending");

        when(taskRepository.save(any(Task.class))).thenReturn(taskOK);

        // We invoke the method to create a task.
        Task result = taskService.createTask(taskError);

        // We test the created objects

        // Test if both id are equal. (Use "taskOK" to get test passed / use "taskError" to get test failed)
        assertEquals(taskOK.getId(), result.getId());

        // Test is both titles are equal. (Use "taskOK" to get test passed / use "taskError" to get test failed)
        assertEquals(taskOK.getTitle(), result.getTitle());

        // Test is both descriptions are equal. (Use "taskOK" to get test passed / use "taskError" to get test failed)
        assertEquals(taskOK.getDescription(), result.getDescription());

        // Test is both status are equal. (Use "taskOK" to get test passed / use "taskError" to get test failed)
        assertEquals(taskOK.getStatus(), result.getStatus());

        // We check if the save method is invoked in taskRepository (Use "taskError" to get test passed / use "taskOK" to get test failed)
        verify(taskRepository, times(1)).save(taskError);
    }

    @Test
    void getTaskByIdSuccessfully() {

        // We declare two Task variables, one with id=1 (taskOK) and another with id=2 (taskError).
        Task taskOK = new Task(1L, "First title", "first description", "Completed");
        Task taskError = new Task(2L, "First title", "first description", "Completed");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskOK));

        Optional<Task> foundTask = taskService.getTaskById(1L);

        // We check if the id value is not null
        assertNotNull(foundTask);

        // We check if the id is equal to that of the test mock
        // (use variable "taskOK" to pass the test / use variable "taskError" to fail the test).
        assertEquals(taskOK.getId(), foundTask.get().getId());
    }

    @Test
    void updateTaskSuccessfully() {

        // We create a Task with initial data.
        Task originalTask = new Task(1L, "Original title", "Original description", "Pending");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(originalTask));
        when(taskRepository.save(any(Task.class))).thenReturn(originalTask);

        // We create a Task with updated data
        Task updatedTask = new Task(1L, "Updated title", "Updated description", "Completed");
        Task result = taskService.updateTask(1L, updatedTask);

        // We validate if the updated attribute "title" matches (Change "Updated title" to fail the test).
        assertEquals("Updated title", result.getTitle());

        // We validate if the updated attribute "description" matches (Change "Updated description" to fail the test).
        assertEquals("Updated description", result.getDescription());

        // We validate if the updated attribute "status" matches (Change "Completed" to fail the test).
        assertEquals("Completed", result.getStatus());

        // We validate if the taskRepository saves the Task.
        verify(taskRepository, times(1)).save(any(Task.class));
    }


    @Test
    void deleteTaskSuccessfully() {
        // We initialize a temporary variable and simulate the query to return the taskTemp.
        Task taskTemp = new Task(1L, "Test title", "Test description", "Pending");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(taskTemp));

        // We call the method to delete the Task.
        taskService.deleteTask(1L);

        // Verify that it was searched by id.
        verify(taskRepository, times(1)).findById(1L);
        // Verify that the task was deleted.
        verify(taskRepository, times(1)).delete(taskTemp);
    }

}