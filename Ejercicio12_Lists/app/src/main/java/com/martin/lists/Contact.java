package com.martin.lists;

import java.util.ArrayList;
//import java.util.List;

public class Contact {
    int profilePic;
    String name;
    String status;

    Contact(int profilePic, String name, String status) {
        this.profilePic = profilePic;
        this.name = name;
        this.status = status;
    }

    public static ArrayList<Contact> loadData() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));
        contacts.add(new Contact(R.drawable.picture01, "Bill", "Currently offline"));
        contacts.add(new Contact(R.drawable.picture02, "Sally", "Currently busy"));
        contacts.add(new Contact(R.drawable.picture03, "Janet", "Available to chat"));

        return contacts;
    }
}
