package com.martin.notes.model;

import java.util.ArrayList;

public interface NotesRepository {
    ArrayList<Note> getNotes();
    int addNote(Note note);
    void deleteNote(int id);
    Note getNote(int id);
}
