package com.martin.notes;

import android.app.Application;

import com.martin.notes.model.MemoryNoteRepository;
import com.martin.notes.model.NotesRepository;

public class NotesApplication extends Application {
    private static NotesRepository repository;

    public static NotesRepository getRepository() {
        return repository;
    }

    @Override
    public void onCreate() {
        repository = new MemoryNoteRepository();
        super.onCreate();
    }
}
