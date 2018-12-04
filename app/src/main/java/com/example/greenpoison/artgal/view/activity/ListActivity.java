package com.example.greenpoison.artgal.view.activity;
import com.example.greenpoison.artgal.listAdapter;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;
import com.example.greenpoison.artgal.presenter.impl.MainAPresenterImpl;
import com.example.greenpoison.artgal.presenter.inter.IMainAPresenter;
import com.example.greenpoison.artgal.view.inter.IMainAView;
import com.example.greenpoison.artgal.R;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements IMainAView {

    List<Painting> paintings = null;
    private IMainAPresenter mIMainAPresenter;
    private RecyclerView mRecyclerView;
    private listAdapter listAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        paintings = new ArrayList<>();
        mIMainAPresenter = new MainAPresenterImpl(this);
        mIMainAPresenter.initDatabase(this);
        mIMainAPresenter.getAllFromDatabase();

        mRecyclerView = findViewById(R.id.recycler_view);
        listAdapter = new listAdapter(paintings);
        mRecyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    public <T> T request(int requestFlag) {
        return null;
    }

    @Override
    public <T> void response(T response, int responseFlag) {
        if (responseFlag == 404){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Ошибка")
                    .setMessage("Приложение не может получить ответ от сервера. Возможны проблемы с интернет-соединением")
                    .setCancelable(false)
                    .setNegativeButton("ОК",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                    ListActivity.this.finish();
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    @Override
    public void setTextWithAllElem(List input) {
        Log.e("AFFFAFAFA", "XUUUUUUUUUUUUUUI");
        paintings.clear();
        paintings.addAll(input);
        listAdapter.notifyDataSetChanged();
    }
}
