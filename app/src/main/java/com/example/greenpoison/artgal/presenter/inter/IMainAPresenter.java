package com.example.greenpoison.artgal.presenter.inter;

import android.content.Context;

public interface IMainAPresenter {
    void initDatabase(Context context);
    void insertToDatabase(String name, String descr);
    void getAllFromDatabase();
}
