package com.example.greenpoison.artgal.model.DatabaseStuff;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient  {
    private static final RetroClient ourInstance = new RetroClient();
    private Retrofit retrofit;
    public static RetroClient getInstance() {
        return ourInstance;
    }

    private RetroClient() {
         retrofit = new Retrofit.Builder().baseUrl("http://192.168.100.2/ArtGalApi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return ourInstance.retrofit;
    }
}


/*public class App extends Application {
 
    public static App instance;
 
    private AppDatabase database;
 
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }
 
    public static App getInstance() {
        return instance;
    }
 
    public AppDatabase getDatabase() {
        return database;
    }
}*/