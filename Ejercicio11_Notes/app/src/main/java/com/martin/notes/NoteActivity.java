package com.martin.notes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import com.martin.notes.model.Note;

public class NoteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null) {
            setActionBar(toolbar);
        }

        int id = getIntent().getIntExtra("id", -1);
        Note note = NotesApplication.getRepository().getNote(id);

        TextView titleTV = findViewById(R.id.titleTextView);
        titleTV.setText(note.getTitle());

        TextView textTV = findViewById(R.id.textTextView);
        textTV.setText(note.getText());
    }
}
