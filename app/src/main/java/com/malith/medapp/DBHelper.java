package com.malith.medapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "medapp.db";

    public DBHelper(Context context) {
        super(context, "medapp.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table mlogUsers (username TEXT PRIMARY KEY, password TEXT, email TEXT, mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists mlogUsers");
    }

    public boolean insertData(String username, String password, String email, String mobile){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues  contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        long result = sqLiteDatabase.insert("mlogUsers", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public boolean checkUsername(String username){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from mlogUsers where username = ?", new String[] {username} );
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from mlogUsers where username = ? and password = ?", new String[] {username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
}
