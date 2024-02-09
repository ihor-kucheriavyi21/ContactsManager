package com.devexpert.contactsmanager.db;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ContactRepository {

    private final ContactDAO contactDAO;
    private final ExecutorService executorService;

    public ContactRepository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();
        executorService = Executors.newSingleThreadExecutor();
    }

    public void addContact(Contact contact) {
        executorService.execute(() -> contactDAO.insert(contact));
    }

    public void deleteContact(Contact contact) {
        executorService.execute(() -> contactDAO.delete(contact));
    }

    public LiveData<List<Contact>> getAllContacts() {
        return contactDAO.getAllContacts();
    }
}
