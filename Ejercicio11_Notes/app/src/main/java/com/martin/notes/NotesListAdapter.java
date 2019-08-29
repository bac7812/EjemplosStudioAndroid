package com.martin.notes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.martin.notes.model.Note;

import java.util.ArrayList;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NoteViewHolder> {
    private ArrayList<Note> notes;

    public NotesListAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }
    private OnItemClickListener listener;
    private OnLongItemClickListener longListener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, Note note);
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(View itemView, Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setOnLongItemClickListener(OnLongItemClickListener listener) {
        this.longListener = listener;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(v);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public final class NoteViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, View.OnLongClickListener {
        TextView title;

        public NoteViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.itemTitleTextView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.onItemClick(view, notes.get(getAdapterPosition()));
            }
        }

        @Override
        public boolean onLongClick(View view) {
            if(longListener != null) {
                longListener.onLongItemClick(view,
                        notes.get(getAdapterPosition()));
            }
            return true;
        }
    }
}