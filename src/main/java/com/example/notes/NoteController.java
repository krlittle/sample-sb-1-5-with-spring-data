package com.example.notes;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteRepository notes;

    public NoteController(NoteRepository notes) {
        this.notes = notes;
    }

    @PostMapping
    public Note save(@RequestBody Note note) {
        return notes.save(note);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> read(@PathVariable Long id) {
        Note note = notes.findOne(id);
        if (note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        notes.delete(id);
        return ResponseEntity.noContent().build();
    }
}
