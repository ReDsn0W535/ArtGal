package com.example.greenpoison.artgal;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ArtObj{
    @PrimaryKey (autoGenerate = true) public long id;
    public String name;
    public String decr;
}
