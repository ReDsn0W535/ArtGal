package com.example.greenpoison.artgal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ArtDao{
    @Query("SELECT * FROM ArtObj")
    List<ArtObj> getAll();

    @Query("SELECT * FROM ArtObj WHERE id = :id")
    ArtObj getById(long id);

    @Insert
    void insert(ArtObj employee);

    @Update
    void update(ArtObj employee);

    @Delete
    void delete(ArtObj employee);
}
