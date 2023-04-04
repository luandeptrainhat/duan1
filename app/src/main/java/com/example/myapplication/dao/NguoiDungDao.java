package com.example.myapplication.dao;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.database.Dbhelper;


public class NguoiDungDao {
    Dbhelper dbHelper;

    SharedPreferences sharedPreferences;

    public NguoiDungDao(Context context){
        dbHelper = new Dbhelper(context);
        sharedPreferences = context.getSharedPreferences("THONGTIN",MODE_PRIVATE);
    }
    public  boolean kiemtradangnhap(String taikhoan, String matkhau){
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE taikhoan = ? AND matkhau = ?",new String[]{taikhoan,matkhau});
        if (cursor.getCount() != 0){

            cursor.moveToFirst();
<<<<<<< HEAD

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("taikhoan",cursor.getString(0));

            editor.putString("matkhau",cursor.getString(1));
            editor.putInt("phanquyen",cursor.getInt(2));

            editor.putString("phanquyen",cursor.getString(2));

            editor.commit();

=======
>>>>>>> parent of 1eba36f (fix dao)
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("taikhoan",cursor.getString(0));
//            editor.putString("matkhau",cursor.getString(1));
        //    editor.commit();
<<<<<<< HEAD

=======
>>>>>>> parent of 1eba36f (fix dao)
            return true;
        }else {
            return false;
        }
    }
    public int doimatkhau(String taikhoan, String matkhau,String matkhaumoi ){
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE taikhoan = ? AND matkhau = ?",new String[]{taikhoan,matkhau});
        if (cursor.getCount() > 0){
            ContentValues contentValues = new ContentValues();
            contentValues.put("matkhau  ",matkhaumoi);
            long check = sqLiteDatabase.update("NGUOIDUNG",contentValues,"taikhoan = ?",new String[]{taikhoan});
            if (check == -1)
                return -1;
            return 1;
        }
        return 0;
    }


public  boolean them(String taikhoan, String matkhau, int phanquyen){
    SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put("taikhoan", taikhoan);
    contentValues.put("matkhau",matkhau);
    contentValues.put("phanquyen",phanquyen);

    long check = sqLiteDatabase.insert("NGUOIDUNG", null,contentValues);
    if(check ==-1){
        return  false;
    }

    return  true;

}
}
