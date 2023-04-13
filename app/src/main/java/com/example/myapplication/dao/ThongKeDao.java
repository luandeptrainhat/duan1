package com.example.myapplication.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;

public class ThongKeDao {
    private Dbhelper dbhelper;
    public  ThongKeDao(Context context){
       dbhelper = new Dbhelper(context);
    }
    public float[] getThongTinThuChi() {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        int giaythethao = 0, giayluoi = 0, giayleonui = 0;

        Cursor cursorGiaythethao = sqLiteDatabase.rawQuery("select sum(giagiay) from GIAY where magiay in (select magiay  from DONHANG where trangthai = 1 AND GIAY.maloaigiay = 1) ", null);

        if (cursorGiaythethao.getCount() != 0) {
            cursorGiaythethao.moveToFirst();
            giaythethao = cursorGiaythethao.getInt(0);
        }
        Cursor cursorgiayluoi = sqLiteDatabase.rawQuery("select sum(giagiay) from GIAY where magiay in (select magiay  from DONHANG where trangthai = 1 AND GIAY.maloaigiay = 2) ", null);

        if (cursorgiayluoi.getCount() != 0) {
            cursorgiayluoi.moveToFirst();
            giayluoi = cursorgiayluoi.getInt(0);
        }
        Cursor cursorgiayleonui = sqLiteDatabase.rawQuery("select sum(giagiay) from GIAY where magiay in (select magiay  from DONHANG where trangthai = 1 AND GIAY.maloaigiay = 3", null);

        if (cursorgiayleonui.getCount() != 0) {
            cursorgiayleonui.moveToFirst();
            giayleonui = cursorgiayleonui.getInt(0);
        }





        float[] ketQua = new float[]{giaythethao,giayluoi,giayleonui};
        return ketQua;
    }

}
