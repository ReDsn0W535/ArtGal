package com.example.greenpoison.artgal.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.greenpoison.artgal.model.DatabaseStuff.Painting;
import com.example.greenpoison.artgal.R;
import com.example.greenpoison.artgal.presenter.impl.MainAPresenterImpl;
import com.example.greenpoison.artgal.presenter.inter.IMainAPresenter;
import com.example.greenpoison.artgal.view.inter.IMainAView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    TextView nameView;
    Button button;
    Button getall;
    TextView textView;
    //private IMainAPresenter mIMainAPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*mIMainAPresenter = new MainAPresenterImpl(this);
        mIMainAPresenter.initDatabase(this);*/

        setContentView(R.layout.activity_main);
        nameView = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(oclBtnOk);
        getall = findViewById(R.id.button2);
        getall.setOnClickListener(getAll);
        textView = findViewById(R.id.textView);

        Intent intent = new Intent(this,LoginActivity.class);
        startActivityForResult(intent,1);
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
    }

    View.OnClickListener oclBtnOk = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           // mIMainAPresenter.insertToDatabase(nameView.getText().toString(), null);
        }
    };

    View.OnClickListener getAll = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
            //mIMainAPresenter.getAllFromDatabase();
        }
    };
}



