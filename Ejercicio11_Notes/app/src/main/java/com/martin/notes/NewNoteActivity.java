package com.martin.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.martin.notes.model.Note;

public class NewNoteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);
    }

    public void saveButtonClicked(View view) {
        String title = ((EditText)findViewById(R.id.titleEditText))
                .getText().toString();
        String text = ((EditText)findViewById(R.id.textEditText))
                .getText().toString();

        Note newNote = new Note(title, text);

        NotesApplication.getRepository().addNote(newNote);

        finish();
    }
}
