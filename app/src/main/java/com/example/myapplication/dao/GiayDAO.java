package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;

import java.util.ArrayList;

public class GiayDAO {
    private Dbhelper dbhelper;
    public GiayDAO (Context context){
        dbhelper = new Dbhelper(context);
    }
//    public boolean themGiay(){
//
//    }
    public void getGiay(){
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM GIAY",null);
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
//                magiay, String tengiay, int gia, int soluong, String mausac, int kichco, int anh, int maloaigiay

            }while (cursor.moveToNext());
        }
    }
}
