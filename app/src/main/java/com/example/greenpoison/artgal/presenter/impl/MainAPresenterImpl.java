package com.example.greenpoison.artgal.presenter.impl;

import android.content.Context;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;
import com.example.greenpoison.artgal.model.impl.MainAModelImpl;
import com.example.greenpoison.artgal.model.inter.IMainAModel;
import com.example.greenpoison.artgal.presenter.callback.CallBack;
import com.example.greenpoison.artgal.presenter.inter.IMainAPresenter;
import com.example.greenpoison.artgal.view.inter.IMainAView;

import java.util.List;

public class MainAPresenterImpl implements IMainAPresenter{
    private IMainAView mIMainAView;
    private IMainAModel mIMainAModel;
    private DatabaseCallback mCallback = new DatabaseCallback();
    public MainAPresenterImpl(IMainAView aIMainAView) {
        mIMainAView = aIMainAView;
        mIMainAModel = new MainAModelImpl();
        mIMainAModel.registerCallback(mCallback);
    }

    @Override
    public void initDatabase(Context context) {
        mIMainAModel.createDatabase(context);
    }

    @Override
    public void insertToDatabase(String name, String descr) {
        /*Painting input = new Painting();
        if(descr != null)
            input.decr = descr;
        else input.decr = "";
        if(name != null)
            input.name = name;
        else input.name = "";
        mIMainAModel.insert(input);*/
    }

    @Override
    public void getAllFromDatabase() {
        mIMainAModel.getAll();
    }

    class DatabaseCallback implements CallBack {

        @Override
        public void retAllFromDatabase(List input) {
            mIMainAView.setTextWithAllElem(input);
        }

        @Override
        public void getNoInternetError() {
            mIMainAView.response(null, 404);  //404- no internet
        }
    }



}