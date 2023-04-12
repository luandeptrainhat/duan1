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
        int thu = 0;

        Cursor cursorThu = sqLiteDatabase.rawQuery("select sum(giagiay) from GIAY where magiay in (select magiay from DONHANG where trangthai = 1) ", null);

        if (cursorThu.getCount() != 0) {
            cursorThu.moveToFirst();
            thu = cursorThu.getInt(0);
        }




        float[] ketQua = new float[]{thu};
        return ketQua;
    }

}
