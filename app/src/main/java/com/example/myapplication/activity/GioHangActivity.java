package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GiayUserAdapter;
import com.example.myapplication.adapter.Giayadapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class GioHangActivity extends AppCompatActivity {
    RecyclerView recycleviewGioHang;
    GiayDAO dao;
    ArrayList<Product> list;
    Giayadapter giayadapter;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);
        showList();

    }
    private void showList() {
        list = new ArrayList<>();
        dao = new GiayDAO(getApplicationContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleviewGioHang.setLayoutManager(linearLayoutManager);
        list = dao.getDSPRO();
        giayadapter = new Giayadapter(this, list, dao);
        recycleviewGioHang.setAdapter(giayadapter);
    }
}