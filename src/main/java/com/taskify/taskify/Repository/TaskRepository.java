package com.taskify.taskify.Repository;

import com.taskify.taskify.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Wait until Milestone 4...
}
