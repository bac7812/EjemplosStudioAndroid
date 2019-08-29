package com.martin.lists;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter<ContactViewHolder>{
//        implements View.OnClickListener {

    private ArrayList<Contact> contacts;
 //   private View.OnClickListener listener;

    public RecyclerViewAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        ContactViewHolder contactViewHolder = new ContactViewHolder(v);

//        v.setOnClickListener(this);

        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        holder.profilePic.setImageResource(contacts.get(position).profilePic);
        holder.name.setText(contacts.get(position).name);
        holder.status.setText(contacts.get(position).status);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

//    public void setOnClickListener(View.OnClickListener listener) {
//        this.listener = listener;
//    }

//    @Override
//    public void onClick(View view) {
//        if(listener != null)
//            listener.onClick(view);
//    }
}
