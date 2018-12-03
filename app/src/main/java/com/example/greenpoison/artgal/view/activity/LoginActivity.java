package com.example.greenpoison.artgal.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greenpoison.artgal.R;

public class LoginActivity extends AppCompatActivity {

    TextView fieldLogin;
    TextView fieldPassword;
    Button signUp;
    Button login;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        fieldLogin = findViewById(R.id.LoginField);
        fieldPassword = findViewById(R.id.PassportField);
        signUp = findViewById(R.id.sign_up);
        login = findViewById(R.id.login);
        SharedPreferences userData = getSharedPreferences("userProfile",Context.MODE_PRIVATE);
        editor = userData.edit();
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fieldPassword.getText().toString().equals("")){
                    Toast t = Toast.makeText(LoginActivity.this, "Password could contains at least one symbol", Toast.LENGTH_LONG);
                    t.show();
                } else {
                    if (userData.contains(fieldLogin.getText().toString())) {
                        Toast t = Toast.makeText(LoginActivity.this, "User with this login is exist", Toast.LENGTH_LONG);
                        t.show();
                    } else {
                        editor.putString(fieldLogin.getText().toString(), fieldPassword.getText().toString());
                        editor.apply();
                        Toast t = Toast.makeText(LoginActivity.this, "New user created", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userData.contains(fieldLogin.getText().toString())){
                    if (userData.getString(fieldLogin.getText().toString(), "").equals(fieldPassword.getText().toString())){
                        finish();
                    }
                }else {
                    Toast t = Toast.makeText(LoginActivity.this, "This pair login/password not found", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });
    }
}
