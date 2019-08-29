package com.martin.notes.model;

import java.util.ArrayList;

public class MemoryNoteRepository implements NotesRepository {
    private ArrayList<Note> notes;
    private int count;

    public MemoryNoteRepository(){
        this.notes = new ArrayList<>();
        count = 0;

        addNote(new Note("Nota A", "Esto es la nota A"));
        addNote(new Note("Nota B", "Esto es la nota B"));
        addNote(new Note("Nota C", "Esto es la nota C"));
    }

    @Override
    public ArrayList<Note> getNotes() {
        return notes;
    }

    @Override
    public int addNote(Note note) {
        note.setId(count++);
        notes.add(note);
        return count++;
    }

    @Override
    public void deleteNote(int id) {
        for(int posicion = 0; posicion < notes.size(); posicion++){
            if(notes.get(posicion).getId() == id){
                notes.remove(posicion);
                break;
            }
        }
    }

    @Override
    public Note getNote(int id) {
        for (Note n : notes) {
            if(n.getId() == id){
                return n;
            }
        }
        return null;
    }
}
