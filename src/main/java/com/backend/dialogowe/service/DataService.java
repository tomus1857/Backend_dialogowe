package com.backend.dialogowe.service;

import com.backend.dialogowe.entity.Note;
import com.backend.dialogowe.entity.Task;
import com.backend.dialogowe.entity.User;
import com.backend.dialogowe.repository.NoteRepository;
import com.backend.dialogowe.repository.TaskRepository;
import com.backend.dialogowe.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    public Note addNote(Note note, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        note.setUser(user);
        note.setDate(LocalDate.now());
        return noteRepository.save(note);
    }

    public Task addTask(Task task, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        task.setUser(user);
        return taskRepository.save(task);
    }

    public List<Note> getAllNotes(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        return noteRepository.findByUser(user);
    }

    public List<Task> getAllTasks(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        return taskRepository.findByUser(user);
    }

    public void deleteNote(Long id, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notatka nie znaleziona"));
        //if (!note.getUser().equals(user)) {
            //throw new RuntimeException("Brak uprawnień do usunięcia tej notatki");
       // }
        noteRepository.delete(note);
    }

    public void deleteTask(Long id, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Zadanie nie znalezione"));
        //if (!task.getUser().equals(user)) {
            //throw new RuntimeException("Brak uprawnień do usunięcia tego zadania");
        //}
        taskRepository.delete(task);
    }
}
