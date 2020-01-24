package com.example.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLDao extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "mydb";
    static final int VERSION = 2;
    static final String USER_TABLE = "user";
    static final String ID = "id";
    static final String NAME="name";
    static final String PASSWORD = "password";
    static final String EMAIL = "email";
    static final String GENDER = "gender";

    Context context;
    static final String CREATE_USER_TABLE_v2 = "create table "+ USER_TABLE +
            "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" text, "+PASSWORD+" text,"+GENDER+" text,"+EMAIL+" text)";
    static final String DROP_USER_TABLE = "DROP table IF EXISTS "+USER_TABLE+"";
//    static final String CREATE_USER_TABLE_V1 = "create table "+ USER_TABLE +
//            "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" text, "+PASSWORD+" text,"+GENDER+" text,"+EMAIL+" text)";
    public SQLDao(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
//        Log.d("successful","yes");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.d("signUp","message created");
        try {
            db.execSQL(CREATE_USER_TABLE_v2);

        }catch (Exception e){
            Log.d("DB",e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_USER_TABLE);
            onCreate(db);
        }catch (Exception e){
            Log.d("error ",e.getMessage());
        }
    }
    public long insertUser (String name,String password,String gender,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(PASSWORD,password);
        contentValues.put(GENDER,gender);

        Log.d("upgraded ?","yes");
        Long id = db.insert(USER_TABLE,null,contentValues);
        return id;
    }
}
