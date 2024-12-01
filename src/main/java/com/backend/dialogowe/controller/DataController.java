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

    @PostMapping("/note")
    public ResponseEntity<Note> addNote(@RequestBody Note note, @RequestParam String email) {
        Note savedNote = dataService.addNote(note, email);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }

    @PostMapping("/task")
    public ResponseEntity<Task> addTask(@RequestBody Task task, @RequestParam String email) {
        Task savedTask = dataService.addTask(task, email);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/notes")
    public ResponseEntity<List<Note>> getAllNotes(@RequestParam String email) {
        List<Note> notes = dataService.getAllNotes(email);
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam String email) {
        List<Task> tasks = dataService.getAllTasks(email);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @DeleteMapping("/note/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id, @RequestParam String email) {
        dataService.deleteNote(id, email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id, @RequestParam String email) {
        dataService.deleteTask(id, email);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
