package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
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
       CardView MuaNgay;
    Product product;
    String tk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);
        LinearLayout linearLayout = findViewById(R.id.linnia);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        MuaNgay = findViewById(R.id.MuaNgay);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN",MODE_PRIVATE);
         tk = sharedPreferences.getString("taikhoan",null);
         product = (Product) bundle.getSerializable("truyenne");

        TextView txtdelta = findViewById(R.id.txtten);
        txtdelta.setText(product.getTengiay());
        TextView txtgia = findViewById(R.id.txtgia);
        txtgia.setText(String.valueOf(product.getGia()));
        MuaNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                0 là chưa xác nhận
                if(dao.themVaoDH(0,tk,product.getMagiay(),1)){
                    Toast.makeText(Deltalitem.this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Deltalitem.this, "Đặt hang thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
      //  adapter = new GiayUserAdapter(this,list, dao);
        dao = new GiayDAO(Deltalitem.this);
         btndathang = findViewById(R.id.btndathang);
         btndathang.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 if (dao.themVaoGH(product.getMagiay(),1,tk)){
                     Toast.makeText(Deltalitem.this, "thêm vào giỏ hàng thành công", Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(Deltalitem.this, "thất bại", Toast.LENGTH_SHORT).show();
                 }
             }
         });

    }

}


