package com.example.greenpoison.artgal;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ArtObj.class}, version = 1)
public abstract class ArtDatabase extends RoomDatabase {
    public abstract ArtDao getArtDao();
}
