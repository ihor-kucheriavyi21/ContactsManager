package com.devexpert.contactsmanager.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.devexpert.contactsmanager.AddNewContactActivity;

public class MainActivityClickHandlers {

    Context context;

    public MainActivityClickHandlers(Context context) {
        this.context = context;
    }

    public void onFABClicked(View view) {
        Intent intent = new Intent(view.getContext(), AddNewContactActivity.class);
        context.startActivity(intent);
    }
}
