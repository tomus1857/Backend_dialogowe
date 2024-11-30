package com.backend.dialogowe.repository;

import com.backend.dialogowe.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
