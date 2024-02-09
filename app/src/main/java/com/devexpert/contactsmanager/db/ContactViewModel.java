package com.devexpert.contactsmanager.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ContactViewModel extends AndroidViewModel {

    private final ContactRepository myContactRepository;

    public ContactViewModel(@NonNull Application application) {
        super(application);
        this.myContactRepository = new ContactRepository(application);
    }

    public LiveData<List<Contact>> getAllContacts() {
        return myContactRepository.getAllContacts();
    }

    public void addNewContact(Contact contact) {
        myContactRepository.addContact(contact);
    }

    public void deleteContact(Contact contact) {
        myContactRepository.deleteContact(contact);
    }
}
