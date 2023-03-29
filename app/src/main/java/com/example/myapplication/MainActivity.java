package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.adapter.testadapter;
import com.example.myapplication.dao.TestDAO;
import com.example.myapplication.database.Dbhelper;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     testadapter testAdapter;
    ArrayList<Product> list;
     TestDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycleview);
        dao = new TestDAO(MainActivity.this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        list = dao.getDSPRO();
        testAdapter = new testadapter(this,list);
        recyclerView.setAdapter(testAdapter);


//luan dep ttrai
    }
}