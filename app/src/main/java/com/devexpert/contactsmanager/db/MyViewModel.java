package com.devexpert.contactsmanager.db;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private final Repository myRepository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new Repository(application);
    }

    public LiveData<List<Contact>> getAllContacts() {
        return myRepository.getAllContacts();
    }

    public void addNewContact(Contact contact) {
        myRepository.addContact(contact);
    }

    public void deleteContact(Contact contact) {
        myRepository.deleteContact(contact);
    }
}
