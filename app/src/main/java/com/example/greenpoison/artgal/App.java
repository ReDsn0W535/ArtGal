package com.example.greenpoison.artgal;

import android.app.Application;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

public class App {
    public static App instance;

    private ArtDatabase database;
    public App(Context context) {
        instance = this;
        database = Room.databaseBuilder(context, ArtDatabase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public ArtDatabase getDatabase() {
        return database;
    }
}


