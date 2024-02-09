package com.devexpert.contactsmanager.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.devexpert.contactsmanager.R;
import com.devexpert.contactsmanager.databinding.ContactListItemBinding;
import com.devexpert.contactsmanager.db.Contact;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private final ArrayList<Contact> contacts;

    public ContactAdapter(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ContactListItemBinding contactListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.contact_list_item,
                parent,
                false);
        return new ContactViewHolder(contactListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact currentContact = contacts.get(position);
        holder.contactListItemBinding.setContact(currentContact);
    }

    @Override
    public int getItemCount() {
        if (contacts != null)
            return contacts.size();
        else
            return 0;
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        private final ContactListItemBinding contactListItemBinding;

        public ContactViewHolder(ContactListItemBinding contactListItemBinding) {
            super(contactListItemBinding.getRoot());
            this.contactListItemBinding = contactListItemBinding;
        }
    }
}
