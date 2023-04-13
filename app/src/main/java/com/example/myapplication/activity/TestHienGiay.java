package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.Giayadapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class TestHienGiay extends AppCompatActivity {
    RecyclerView recyclerView;
    GiayDAO giayDAO;
    Giayadapter giayadapter;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hien_giay);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        recyclerView = findViewById(R.id.recycleview);
        list = new ArrayList<>();
        giayDAO = new GiayDAO(this);
        getDS();
    }
    private void getDS (){
        list = giayDAO.getDSPRO();
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(TestHienGiay.this);
//        recyclerView.setLayoutManager(linearLayoutManager);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(TestHienGiay.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        giayadapter = new Giayadapter(this,list,giayDAO);
        recyclerView.setAdapter(giayadapter);

    }
}