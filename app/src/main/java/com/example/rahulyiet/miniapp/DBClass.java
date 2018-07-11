package com.example.rahulyiet.miniapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBClass extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;

    public DBClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE USER (Email text,Password text,Number text,Type text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);

    }

    public boolean addData(String email, String password, String number, String type) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Email", email);
        contentValues.put("Password", password);
        contentValues.put("Number", number);
        contentValues.put("Type", type);

        long status = sqLiteDatabase.insert("USER", null, contentValues);
        contentValues.clear();

        return (status > -1);
    }


    Cursor getData() {

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("USER", null, null, null, null, null, null);

        return cursor;

    }

    // delete data

    public void onDelete(String email) {

        SQLiteDatabase db = getWritableDatabase();

        String[] arr = null;
        arr[0] = email;

        db.delete("USER", "Email = ? ", arr);

    }

    public Cursor Login(String email, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("Select Email,Password,Type,Phone FROM USER WHERE Name=? AND Password=?", new String[]{email, password
        });
        return cursor;


//
    }
    // update Data

       boolean Update (String email){
        int update;
        SQLiteDatabase db=getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Email",email);
        String arr[]={""};
        arr[0]=email;
        update=db.update("USER",contentValues,"Email=?",arr);
        return (update>-1);
       }

}