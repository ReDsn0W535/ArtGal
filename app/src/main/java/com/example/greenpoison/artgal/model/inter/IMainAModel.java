package com.example.greenpoison.artgal.model.inter;

import android.content.Context;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;
import com.example.greenpoison.artgal.presenter.callback.CallBack;

import java.util.List;
import java.util.concurrent.Future;

public interface IMainAModel {
    void createDatabase(Context context);
    void insert(Painting input);
    void registerCallback(CallBack callBack);
    Future<List<Painting>> getAll();
}
