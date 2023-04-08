package com.example.myapplication.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class motasanpham extends AppCompatActivity {
    Button btnthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motasanpham);

        btnthem = findViewById(R.id.tnt);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdialog();
               // Toast.makeText(motasanpham.this, "aaaaaaaaa", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showdialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(motasanpham.this);
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialogsize,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();



        Button btndathang = dialog.findViewById(R.id.buttonthemvaogiohang);
        Button btngiam = dialog.findViewById(R.id.buttongiam);
        Button btntang = dialog.findViewById(R.id.buttontang);
        RadioButton rdo1 = dialog.findViewById(R.id.radioButton1);
        RadioButton rdo2 = dialog.findViewById(R.id.radioButton2);
        RadioButton rdo3 = dialog.findViewById(R.id.radioButton3);
        TextView txtso = dialog.findViewById(R.id.txtsp);
//                btndathang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(motasanpham.this, "Đạt hàng thành công", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
        dialog.show();
    }
}