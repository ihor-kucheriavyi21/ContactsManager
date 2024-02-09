package com.devexpert.contactsmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.devexpert.contactsmanager.databinding.ActivityAddNewContactBinding;
import com.devexpert.contactsmanager.db.Contact;
import com.devexpert.contactsmanager.db.ContactViewModel;
import com.devexpert.contactsmanager.ui.AddNewContactClickHandler;

public class AddNewContactActivity extends AppCompatActivity {

    private ActivityAddNewContactBinding addNewContactBinding;
    private AddNewContactClickHandler handler;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        contact = new Contact();

        addNewContactBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_add_new_contact);

        ContactViewModel viewModel = new ViewModelProvider(this).get(ContactViewModel.class);
        handler = new AddNewContactClickHandler(contact, this, viewModel);

        addNewContactBinding.setContact(contact);
        addNewContactBinding.setClickHandler(handler);
    }
}