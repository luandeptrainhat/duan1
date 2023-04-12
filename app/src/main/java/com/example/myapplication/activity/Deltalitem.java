package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GiayUserAdapter;
import com.example.myapplication.adapter.GioHangAdapter;
import com.example.myapplication.dao.GiayDAO;
import com.example.myapplication.model.ItemGioHang;
import com.example.myapplication.model.Product;

import java.util.ArrayList;

public class Deltalitem extends AppCompatActivity {
    RecyclerView recycleviewGioHang;
    GiayDAO dao;
    ArrayList<ItemGioHang> list1;
    GiayUserAdapter adapter;

    ArrayList<Product> list;
    Button btndathang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);
        LinearLayout linearLayout = findViewById(R.id.linnia);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dao = new GiayDAO(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Product product = (Product) bundle.get("truyenne");

        TextView txtdelta = findViewById(R.id.txtten);
        txtdelta.setText(product.getTengiay());
        TextView txtgia = findViewById(R.id.txtgia);
        txtgia.setText(String.valueOf(product.getGia()));
        adapter = new GiayUserAdapter(this, list, dao);
        btndathang = findViewById(R.id.btndathang);
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                item();
            }
        });

    }

    public void item() {



//        GiayDAO dao = new GiayDAO(this);
//        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",Context.MODE_PRIVATE);
//        String tk = sharedPreferences.getString("taikhoan",null);
//
//        if(dao.themVaoGH(list.get(position).getMagiay(),1,String.valueOf(tk))){
//            Toast.makeText(this, "thêm thành công", Toast.LENGTH_SHORT).show();
//            startActivity(new Intent(Deltalitem.this, GioHangActivity.class));
//        }else {
//            Toast.makeText(this, "thất bại", Toast.LENGTH_SHORT).show();
//
//    }
    }
}



