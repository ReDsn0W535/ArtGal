package com.example.greenpoison.artgal.model.DatabaseStuff;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Painting.class}, version = 1)
public abstract class ArtDatabase extends RoomDatabase {
    public abstract ArtDao getArtDao();
}
