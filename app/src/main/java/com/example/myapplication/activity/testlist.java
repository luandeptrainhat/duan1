package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.ItemGioHang;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class testlist extends AppCompatActivity {
    GiayDAO giayDAO;
    ArrayList<ItemGioHang> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlist);
        giayDAO = new GiayDAO(this);
//        list = new ArrayList<>();
//        list = giayDAO.layItemGioHang("dungdo");
//        for (ItemGioHang item : list ){
//            Toast.makeText(this, ""+item.getTen(), Toast.LENGTH_SHORT).show();
//        }
        if(giayDAO.themVaoGH(1,2,"dungdo")){
            Toast.makeText(this, "thêm thành công", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "thất bại", Toast.LENGTH_SHORT).show();
        }

    }

}