package com.example.rahulyiet.miniapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Main4Activity extends AppCompatActivity {
    String email, password, type, phone, updte;
    EditText email4;
    Button delete, update;
    DBClass dbClass = new DBClass(this);

    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        email4 = findViewById(R.id.email4);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);

        final Cursor cursor = dbClass.getData();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



    Cursor cursor1 = dbClass.getData();
        while(cursor.moveToNext())



        email = cursor.getString(cursor1.getColumnIndex("Email"));
        password = cursor.getString(cursor1.getColumnIndex("Password"));
        phone = cursor.getString(cursor1.getColumnIndex("Phone"));
        type = cursor.getString(cursor1.getColumnIndex("Type"));

        updte = email + "\n" + password + "\n" + phone + "\n" + type + "\n";
        arrayList.add(updte);


}
}

