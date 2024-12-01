package com.backend.dialogowe.repository;

import com.backend.dialogowe.entity.Task;
import com.backend.dialogowe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}
