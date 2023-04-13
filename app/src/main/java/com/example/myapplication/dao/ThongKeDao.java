package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.ItemDonHang;

import java.util.ArrayList;

public class ThongKeDao {
    private Dbhelper dbhelper;
    public  ThongKeDao(Context context){
       dbhelper = new Dbhelper(context);
    }
    public float[] getThongTinThuChi() {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        int giaythethao = 0;

        Cursor cursorGiaythethao = sqLiteDatabase.rawQuery("SELECT  GIAY.giagiay " +
                "FROM GIAY " +
                "INNER JOIN DONHANG " +
                "ON GIAY.magiay = DONHANG.magiay " +
                "WHERE   DONHANG.trangthai= 1 ", null);

        if (cursorGiaythethao.getCount() != 0) {
            cursorGiaythethao.moveToFirst();
            giaythethao = cursorGiaythethao.getInt(0);
        }

        float[] ketQua = new float[]{giaythethao};
        return ketQua;
    }
    public float[] layItemDonHang() {
        Float ketQua= Float.valueOf(0);
        ArrayList<Float> sum = new ArrayList<Float>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT  GIAY.giagiay " +
                "FROM GIAY " +
                "INNER JOIN DONHANG " +
                "ON GIAY.magiay = DONHANG.magiay " +
                "WHERE   DONHANG.trangthai= 1", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
               sum.add(cursor.getFloat(0));
            } while (cursor.moveToNext());
        }
        for (Float s: sum){
            ketQua+=s;
        }
        float[] ketQua2 = new float[]{ketQua};
        return ketQua2;
    }

}
