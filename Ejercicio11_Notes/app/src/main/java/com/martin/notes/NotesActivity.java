package com.martin.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.martin.notes.model.Note;

import java.util.ArrayList;

public class NotesActivity extends Activity {

    private RecyclerView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        if(toolbar != null){
            setActionBar(toolbar);
        }

        listView = findViewById(R.id.notesList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);

        listView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        ArrayList<Note> notes = NotesApplication.getRepository().getNotes();
        NotesListAdapter notesListAdapter = new NotesListAdapter(notes);
        listView.setAdapter(notesListAdapter);

        notesListAdapter.setOnItemClickListener(
                new NotesListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, Note note) {
                        Intent intent =
                                new Intent(getBaseContext(), NoteActivity.class);
                        intent.putExtra("id", note.getId());
                        NotesActivity.this.startActivity(intent);
                    }
                }
        );

        notesListAdapter.setOnLongItemClickListener(
                new NotesListAdapter.OnLongItemClickListener() {
                    @Override
                    public void onLongItemClick(View itemView, Note note) {
                        NotesApplication.getRepository().deleteNote(note.getId());
                        onResume();
                    }
                }
        );

        super.onResume();
    }

    public void newNoteButtonClicked(View view) {
        Intent intent = new Intent(this, NewNoteActivity.class);
        startActivity(intent);
    }
}
