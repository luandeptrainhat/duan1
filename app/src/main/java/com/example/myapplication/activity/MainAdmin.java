package com.example.myapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.dao.NguoiDungDao;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainAdmin extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayout;
    private NavigationView navigationView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setBackground(null);
//        bottomNavigationView.getMenu().getItem(2).isEnabled(savedInstanceState)=false;

        //navi
        drawerLayout = findViewById(R.id.drawerLayout);


        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        View headerLayout = navigationView.getHeaderView(0);


        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.baseline_menu_24);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
                int id = item.getItemId();
                switch (id){
                    case R.id.menuThemGiay:
                        Intent intent = new Intent(MainAdmin.this,TestHienGiay.class);
                        startActivity(intent);
                        break;
                    case R.id.menuThemLoai:

                        break;
                    case R.id.menuXuLiDon:

                        break;
                    case R.id.menuDoanhThu:


                        break;
                    case R.id.menuDangXuat:

                       break;
                    case R.id.menuDoiMatKhau:
                       dialogdoimatkhau();
                        break;

                    case R.id.menuThoat:
                        Intent intentt = new Intent(MainAdmin.this, dangnhap.class);
                        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intentt);
                        break;

                }
//                if (fragment != null) {
//                    FragmentManager fragmentManager = getSupportFragmentManager();
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.frameLayout, fragment)
//                            .commit();
//                    toolbar.setTitle(item.getTitle());
//                }

                drawerLayout.closeDrawer(GravityCompat.START);

                return false ;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }
    public  void dialogdoimatkhau(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainAdmin.this)
                .setPositiveButton("Hủy", null);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_doimatkhau, null);


        EditText edtmatkhau = view.findViewById(R.id.edtmatkhaucu);
        EditText edtmatkhaumoi = view.findViewById(R.id.edtmatkhaumoine);
        EditText edtmatkhaumoi1 = view.findViewById(R.id.edtmatkhaumoine1);
        Button btndoiamtkhau  = view.findViewById(R.id.btndoimatkhaune);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
      //  alertDialog.setCancelable(false);
        alertDialog.show();
        btndoiamtkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matkhau = edtmatkhau.getText().toString();
                String matkhaumoi = edtmatkhaumoi.getText().toString();
                String matkhaumoi1 = edtmatkhaumoi1.getText().toString();
                if (matkhau.equals("") || matkhaumoi.equals("") || matkhaumoi1.equals("")) {
                    Toast.makeText(MainAdmin.this, "Bạn cần nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
                } else {
                    if (matkhaumoi.equals(matkhaumoi1)) {
                        SharedPreferences sharedPreferences = getSharedPreferences("THONGTIN", MODE_PRIVATE);
                        String taikhoan = sharedPreferences.getString("taikhoan", "");

                        NguoiDungDao nguoiDungDao = new NguoiDungDao(MainAdmin.this);
                        int check = nguoiDungDao.doimatkhau(taikhoan, matkhau, matkhaumoi);
                        if (check == 1) {
                            Toast.makeText(MainAdmin.this, "Cập nhập mật khẩu thành công", Toast.LENGTH_SHORT).show();
                       //     Intent intent = new Intent(MainAdmin.this, com.example.myapplication.activity.dangnhap.class);
                            //  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                         //   startActivity(intent);
                        } else if (check == 0) {
                            Toast.makeText(MainAdmin.this, "Mật khẩu cũ không đúng", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainAdmin.this, "Cập nhật mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainAdmin.this, "Nhập mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

}