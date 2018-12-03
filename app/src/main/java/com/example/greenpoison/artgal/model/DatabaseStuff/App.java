package com.example.greenpoison.artgal.model.DatabaseStuff;

import android.arch.persistence.room.Room;
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

  /*  public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
            @Override
            public void migrate(final SupportSQLiteDatabase database) {
                database.execSQL("DROP TABLE ArtObj");
                database.execSQL("CREATE TABLE IF NOT EXISTS Painting");
            }
    }*/
