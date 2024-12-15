package com.taskify.taskify;

import com.taskify.taskify.Repository.TaskRepository;
import com.taskify.taskify.model.Task;
import com.taskify.taskify.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void CreateTaskSuccessfully(){

        // We simulate the behavior of the repository.
        Task task = new Task(1L, "Random title", "Random description", "Pending");
        when(taskRepository.save(any(Task.class))).thenReturn(task);

    }
}
