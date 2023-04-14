package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.LoaiGiay;

import java.util.ArrayList;
//
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
                        cursor.getInt(0),
                        cursor.getString(1)
                ));
            }while (cursor.moveToNext());
        }
        return  list;
    }
    public boolean themLoaiGiay (LoaiGiay loaiGiay){
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai",loaiGiay.getTenloai());
        long check  = sqLiteDatabase.insert("LOAIGIAY",null,contentValues);
        return check > 0;
    }
    public boolean suaLoaiGiay (LoaiGiay loaiGiay){
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tenloai",loaiGiay.getTenloai());
        long check  = sqLiteDatabase.update("LOAIGIAY",contentValues,"maloaigiay = ?", new String[]{String.valueOf(loaiGiay.getMaloai())});
        return check > 0;
    }
    public boolean xoaloaiGiay(int maloaigiay) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("LOAIGIAY", "maloaigiay=?", new String[]{String.valueOf(maloaigiay)});
        return check > 0;
    }
}
