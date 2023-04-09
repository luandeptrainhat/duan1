package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Product;

public class Deltalitem extends AppCompatActivity {

    Button btndathang;
    TextView txtgia;
    TextView txtdelta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);
        LinearLayout linearLayout = findViewById(R.id.linnia);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Product product = (Product) bundle.get("truyenne");
        txtdelta = findViewById(R.id.txtten);
        txtdelta.setText(product.getTengiay());
        txtgia = findViewById(R.id.txtgia);
        txtgia.setText(String.valueOf(product.getGia()));

        btndathang = findViewById(R.id.btndathang);
        btndathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showList();


            }
        });

    }

    private void showList() {

    }
}


