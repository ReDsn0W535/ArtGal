package com.example.greenpoison.artgal.model.impl;

import android.content.Context;
import android.util.Log;

import com.example.greenpoison.artgal.model.DatabaseStuff.App;
import com.example.greenpoison.artgal.model.DatabaseStuff.ArtDatabase;
import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;
import com.example.greenpoison.artgal.model.inter.IMainAModel;
import com.example.greenpoison.artgal.presenter.callback.CallBack;
import com.example.greenpoison.artgal.model.DatabaseStuff.RetroClient;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.example.greenpoison.artgal.model.ServerStuff.ServerApi;

public class MainAModelImpl implements IMainAModel {

    Retrofit retrofit = null;
    ArtDatabase db = null;
    App app = null;
    CallBack callBack;
    public void registerCallback(CallBack inputCallBack){
        this.callBack = inputCallBack;
    }
    ServerApi serverApi;

    @Override
    public void createDatabase(Context context) {
        retrofit = RetroClient.getInstance().getRetrofit();
        serverApi = retrofit.create(ServerApi.class);
        app = new App(context);
        db = App.getInstance().getDatabase();
    }

    @Override
    public void insert(final Painting input) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                db.getArtDao().insert(input);
            }
        }).start(); 
    }

    @Override
    public Future<List<Painting>> getAll() {
    /*class retAll implements Callable<List<Painting>>{
        @Override
        public List<Painting> call() throws Exception {
            Call<List<Painting>> ret = serverApi.getAll();
            ret.enqueue(new Callback<List<Painting>>() {
                @Override
                public void onResponse(Call<List<Painting>> call, Response<List<Painting>> response) {
                    Log.e("MODEL TAG", String.valueOf(response.body().size()));
                    callBack.retAllFromDatabase(response.body());
                }
                @Override
                public void onFailure(Call<List<Painting>> call, Throwable t) {
                    Log.e("MODEL TAG", "FAIURE!!!!!!!!");
                }
            });

            return null;
        }
    }

    retAll retAll = new retAll();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<List<Painting>> future = executor.submit(retAll);
    return future;*/
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Call<List<Painting>> ret = serverApi.getAll();
            ret.enqueue(new Callback<List<Painting>>() {
                @Override
                public void onResponse(Call<List<Painting>> call, Response<List<Painting>> response) {
                    Log.e("MODEL TAG", String.valueOf(response.body().size()));
                    callBack.retAllFromDatabase(response.body());
                }
                @Override
                public void onFailure(Call<List<Painting>> call, Throwable t) {
                    Log.e("MODEL TAG", "FAIURE!!!!!!!!");
                }
            });
        }
    });
    thread.start();
    return null;
    }
}
