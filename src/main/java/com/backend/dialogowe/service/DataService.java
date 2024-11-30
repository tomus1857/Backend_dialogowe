package com.backend.dialogowe.service;

import com.backend.dialogowe.entity.Note;
import com.backend.dialogowe.entity.Task;
import com.backend.dialogowe.repository.NoteRepository;
import com.backend.dialogowe.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;  // Importujemy LocalDate
import java.util.List;

@Service
public class DataService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TaskRepository taskRepository;

    public Note addNote(Note note) {
        // Ustawiamy datę na aktualną datę systemową
        note.setDate(LocalDate.now());
        return noteRepository.save(note);  // Zapisujemy notatkę z ustawioną datą
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
