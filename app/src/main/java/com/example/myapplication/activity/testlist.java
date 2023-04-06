package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemGioHang;

import java.util.ArrayList;

public class testlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testlist);
        GiayDAO giayDAO = new GiayDAO(this);
        ArrayList<ItemGioHang> list = new ArrayList<>();
        list = giayDAO.layItemGioHang("dungdo");
        for (ItemGioHang item : list){
            Toast.makeText(this, ""+item, Toast.LENGTH_SHORT).show();
        }

    }
}