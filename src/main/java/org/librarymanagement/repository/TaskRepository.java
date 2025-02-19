package org.librarymanagement.repository;

import org.librarymanagement.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCategory(String category);
    List<Task> findByPriority(String priority);
    List<Task> findByCompleted(boolean completed);
}

