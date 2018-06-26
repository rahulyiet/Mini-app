package com.example.rahulyiet.miniapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button LOGIN,Reset,Registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password1);
        LOGIN=findViewById(R.id.LOGIN);
        Reset=findViewById(R.id.Reset);
        Registration=findViewById(R.id.Registration);
    }
}
