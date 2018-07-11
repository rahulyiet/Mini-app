package com.example.rahulyiet.miniapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    EditText email,password,phone,type;
    Button button;

    private DBClass dbClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        email = findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        type = findViewById(R.id.type);
        button=findViewById(R.id.button);

        dbClass = new DBClass(this);

        dbClass.addData("email","password","number","type");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1 = email.getText().toString();
                String pass2 = password.getText().toString();
                String phone2 = phone.getText().toString();
                String type1 = type.getText().toString();

                boolean isSuccessfull = dbClass.addData(name1,pass2,phone2,type1);

                if(isSuccessfull){

                    Toast.makeText(Main2Activity.this,"Successful storecd",Toast.LENGTH_SHORT).show();

                }else{

                    Toast.makeText(Main2Activity.this,"OnSuccesful",Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent (Main2Activity.this,Main3Activity.class);
                startActivity(intent);

            }
        });



    }
}
