package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.ItemGioHang;
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
                list.add(new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getBlob(5),
                        cursor.getInt(6)
                ));
            } while (cursor.moveToNext());
        }
        return list;
    }

    // magiay integer primary key autoincrement , tengiay text, giagiay integer, soluong integer, mausac text, kichco integer, anh blob, maloaigiay integer
    public boolean themGiay(Product product) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tengiay", product.getTengiay());
        contentValues.put("giagiay", product.getGia());
        contentValues.put("mausac", product.getMausac());
        contentValues.put("kichco", product.getKichco());
        contentValues.put("anh", product.getAnh());
        contentValues.put("maloaigiay", product.getMaloaigiay());
        long check = sqLiteDatabase.insert("GIAY", null, contentValues);
        return check > 0;
    }

    public boolean suaGiay(Product product) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tengiay", product.getTengiay());
        contentValues.put("giagiay", product.getGia());
        contentValues.put("mausac", product.getMausac());
        contentValues.put("kichco", product.getKichco());
        contentValues.put("anh", product.getAnh());
        contentValues.put("maloaigiay", product.getMaloaigiay());
        long check = sqLiteDatabase.update("GIAY", contentValues, "magiay = ?", new String[]{String.valueOf(product.getMagiay())});
        return check > 0;
    }

    public boolean xoaGiay(int maGiay) {
        SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
        long check = sqLiteDatabase.delete("Giay", "magiay=?", new String[]{String.valueOf(maGiay)});
        return check > 0;
    }
//    magiohang integer , magiay integer ,soluong integer ,taikhoan text
public boolean themVaoGH(int magiay, int soluong,String tk){
    SQLiteDatabase sqLiteDatabase = dbhelper.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("magiay",magiay);
    contentValues.put("soluong",soluong);
    contentValues.put("taikhoan",tk);
    long check = sqLiteDatabase.insert("GIOHANG",null,contentValues);
    return check > 0;
}
    public ArrayList<ItemGioHang> layItemGioHang (String tk) {

        ArrayList<ItemGioHang> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT GIAY.tengiay,GIAY.giagiay,GIOHANG.soluong,GIAY.mausac,GIAY.anh " +
                "FROM GIAY " +
                "INNER JOIN GIOHANG " +
                "ON GIAY.magiay = GIOHANG.magiay " +
                "WHERE GIOHANG.taikhoan= ? ", new String[]{String.valueOf(tk)});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            do {
                list.add(new ItemGioHang(cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getBlob(4)
                ));
            }while (cursor.moveToNext());
        }
        return list;
    }

    public ArrayList<Product> getDsLoai(int maLoai){
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT GIAY.* FROM GIAY INNER JOIN LOAIGIAY ON GIAY.maloaigiay = LOAIGIAY.maloaigiay WHERE LOAIGIAY.maloaigiay = ?", new String[]{String.valueOf(maLoai)});
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                list.add(new Product(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getBlob(5),
                        cursor.getInt(6)
                ));
            } while (cursor.moveToNext());
        }
        return list;
    }
}
