package com.martin.lists;

//import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public final class ContactViewHolder extends RecyclerView.ViewHolder {
    //CardView cardView;
    ImageView profilePic;
    TextView name;
    TextView status;

    public ContactViewHolder(View itemView) {
        super(itemView);
        //cardView = (CardView) itemView.findViewById(R.id.card_view);
        profilePic = itemView.findViewById(R.id.profile_pic);
        name = itemView.findViewById(R.id.name);
        status = itemView.findViewById(R.id.status);
    }
}
