package com.example.rahulyiet.miniapp;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    private ListView ListView;
    private DBClass dbClass;

    ArrayList<String> arrayList =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        ListView = findViewById(R.id.ListView);
        dbClass = new DBClass(this);


        getAllUser();


        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String data = arrayList.get(i);
                String[] arr = data.split("\n");
                String email = arr[0];
                // delete

                dbClass.onDelete(email);
                getAllUser();


            }
        });

    }


    private void getAllUser() {

        Cursor cursor = dbClass.getData();

        final ArrayList<String> arrayList = new ArrayList<>();


        if (cursor.moveToFirst()) {

            do {
                String email = cursor.getString(cursor.getColumnIndex("Email"));
                String password = cursor.getString(cursor.getColumnIndex("Password"));
                String number = cursor.getString(cursor.getColumnIndex("Number"));
                String type = cursor.getString(cursor.getColumnIndex("Type"));

                String totalData = email + "\n" + password + "\n" + number + "\n" + type;
                arrayList.add((totalData));
            } while (cursor.moveToNext());

            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);


        }
    }
}