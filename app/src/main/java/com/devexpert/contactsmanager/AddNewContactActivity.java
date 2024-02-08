package com.devexpert.contactsmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.devexpert.contactsmanager.databinding.ActivityAddNewContactBinding;
import com.devexpert.contactsmanager.db.Contact;
import com.devexpert.contactsmanager.db.MyViewModel;
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

        MyViewModel viewModel = new ViewModelProvider(this).get(MyViewModel.class);
        handler = new AddNewContactClickHandler(contact, this, viewModel);

        addNewContactBinding.setContact(contact);
        addNewContactBinding.setClickHandler(handler);
    }
}