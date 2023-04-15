package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

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
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_product_theoloai);
        recycleviewallgiay=findViewById(R.id.recycleview);
        title= findViewById(R.id.title);
        Intent intent = getIntent();
        int maloaigiay = intent.getIntExtra("loaigiay", 0);
        String title1 = intent.getStringExtra("title");
        title.setText(title1);
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