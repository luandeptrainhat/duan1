package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GiayUserAdapter;
import com.example.myapplication.adapter.Giayadapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class ListAllProduct_theoloai extends AppCompatActivity {
    RecyclerView recycleviewallgiay;
    GiayDAO dao;
    ArrayList<Product> list;
    GiayUserAdapter giayadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_product_theoloai);
        recycleviewallgiay=findViewById(R.id.recycleview);

        Intent intent = getIntent();
        int maloaigiay = intent.getIntExtra("loaigiay", 0);

        showList(maloaigiay);
    }

    private void showList(int maloaigiay) {
        list = new ArrayList<>();
        dao = new GiayDAO(getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleviewallgiay.setLayoutManager(linearLayoutManager);
        list = dao.getDSPROLoai(maloaigiay);
        giayadapter = new GiayUserAdapter(this, list, dao);
        recycleviewallgiay.setAdapter(giayadapter);
    }

}