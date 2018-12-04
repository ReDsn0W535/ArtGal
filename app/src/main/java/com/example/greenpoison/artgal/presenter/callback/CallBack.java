package com.example.greenpoison.artgal.presenter.callback;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;

import java.util.List;

public interface CallBack<T> {
    //void onSuccess(T response);

    //void onError(Throwable t);

    void retAllFromDatabase(List input);
    void getNoInternetError();

}
