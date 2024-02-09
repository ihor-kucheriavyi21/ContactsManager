package com.devexpert.contactsmanager;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devexpert.contactsmanager.db.Contact;
import com.devexpert.contactsmanager.db.MyViewModel;
import com.devexpert.contactsmanager.ui.ContactAdapter;
import com.devexpert.contactsmanager.ui.MainActivityClickHandlers;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Contact> contactsList = new ArrayList<>();

    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.devexpert.contactsmanager.databinding.ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityClickHandlers handlers = new MainActivityClickHandlers(this);
        mainBinding.setClickHandler(handlers);

        RecyclerView recyclerView = mainBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        MyViewModel viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        Contact c1 = new Contact("Ihor", "ihor@gmail.com");
        // viewModel.addNewContact(c1);

        viewModel.getAllContacts().observe(this, contacts -> {
            contactsList.clear();
            for (Contact c : contacts) {
                Log.v("TAGY", c.getName());
                contactsList.add(c);
            }

            contactAdapter.notifyDataSetChanged();
        });

        contactAdapter = new ContactAdapter(contactsList);

        recyclerView.setAdapter(contactAdapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Contact c = contactsList.get(viewHolder.getAdapterPosition());
                viewModel.deleteContact(c);
            }
        }).attachToRecyclerView(recyclerView);
    }
}