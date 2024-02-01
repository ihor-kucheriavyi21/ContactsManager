package com.devexpert.contactsmanager.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    public abstract ContactDAO getContactDAO();

    //Singleton Pattern
    private static ContactDatabase DB_INSTANCE;

    public static synchronized ContactDatabase getInstance(Context context) {
        if (DB_INSTANCE == null) {
            DB_INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ContactDatabase.class,
                            "contacts_db"
                    ).fallbackToDestructiveMigration()
                    .build();
        }
        return DB_INSTANCE;
    }
}
