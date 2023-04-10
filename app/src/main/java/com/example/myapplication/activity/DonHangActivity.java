package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.adapter.DonHangAdapter;
import com.example.myapplication.adapter.Giayadapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemDonHang;

import java.util.ArrayList;

public class DonHangActivity extends AppCompatActivity {
    GiayDAO giayDAO;
    RecyclerView recycleviewdonhang;
    DonHangAdapter adapter;
    ArrayList<ItemDonHang> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_don_hang);
        recycleviewdonhang = findViewById(R.id.recycleviewdonhang);

        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
        String tk = sharedPreferences.getString("taikhoan", null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleviewdonhang.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        giayDAO = new GiayDAO(this);
        list = giayDAO.layItemDonHang(tk);
        adapter = new DonHangAdapter(this,list,giayDAO);

        recycleviewdonhang.setAdapter(adapter);

    }
    private void getDS(){

    }
}