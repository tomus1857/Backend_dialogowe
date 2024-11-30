package com.backend.dialogowe.controller;

import com.backend.dialogowe.entity.Note;
import com.backend.dialogowe.entity.Task;
import com.backend.dialogowe.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/data")
public class DataController {

    @Autowired
    private DataService dataService;

    // Dodanie notatki
    @PostMapping("/note")
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        Note savedNote = dataService.addNote(note);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    // Dodanie zadania
    @PostMapping("/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task savedTask = dataService.addTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Pobranie wszystkich notatek
    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = dataService.getAllNotes();
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    // Pobranie wszystkich zadań
    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = dataService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Usunięcie notatki
    @DeleteMapping("/note/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        dataService.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Usunięcie zadania
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        dataService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
