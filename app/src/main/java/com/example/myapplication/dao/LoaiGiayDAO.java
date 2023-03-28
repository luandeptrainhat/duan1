package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.LoaiGiay;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class LoaiGiayDAO {
    Dbhelper dbhelper;
    public LoaiGiayDAO(Context context) {
        dbhelper = new Dbhelper(context);
    }
    public ArrayList<LoaiGiay> getDSLOAI() {
        ArrayList<LoaiGiay> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM LOAIGIAY", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add( new LoaiGiay(
                        cursor.getString(0),
                        cursor.getString(1)
                ));
            }while (cursor.moveToNext());
        }
        return  list;
    }
}
