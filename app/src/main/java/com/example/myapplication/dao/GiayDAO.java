package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class GiayDAO {
     Dbhelper dbhelper;

    public GiayDAO(Context context) {
        dbhelper = new Dbhelper(context);
    }

    public ArrayList<Product> getDSPRO() {
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM GIAY", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add( new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7)
                        ));
            }while (cursor.moveToNext());
        }
        return  list;
    }
}
