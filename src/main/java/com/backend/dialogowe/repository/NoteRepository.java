package com.backend.dialogowe.repository;

import com.backend.dialogowe.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
