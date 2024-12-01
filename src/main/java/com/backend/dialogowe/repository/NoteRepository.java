package com.backend.dialogowe.repository;

import com.backend.dialogowe.entity.Note;
import com.backend.dialogowe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUser(User user);
}
