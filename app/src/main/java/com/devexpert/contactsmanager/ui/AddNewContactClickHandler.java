package com.devexpert.contactsmanager.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.devexpert.contactsmanager.MainActivity;
import com.devexpert.contactsmanager.db.Contact;
import com.devexpert.contactsmanager.db.ContactViewModel;

public class AddNewContactClickHandler {

    Contact contact;
    Context context;
    ContactViewModel viewModel;

    public AddNewContactClickHandler(Contact contact, Context context,
                                     ContactViewModel contactViewModel) {
        this.contact = contact;
        this.context = context;
        this.viewModel = contactViewModel;
    }

    public void onSubmitBtnClicked(View view) {
        if (contact.getName() == null || contact.getEmail() == null) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);
          /*  intent.putExtra("Name", contact.getName());
            intent.putExtra("Email", contact.getEmail());*/
            Contact c = new Contact(contact.getName(), contact.getEmail());

            viewModel.addNewContact(contact);

            context.startActivity(intent);
        }
    }

}
