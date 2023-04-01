package com.example.myapplication.activity;

import static android.view.Gravity.CENTER;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.fragment.fragmentDa;
import com.example.myapplication.fragment.fragmentLeoNui;
import com.example.myapplication.fragment.fragmentTheThao;
import com.example.myapplication.fragment.fragmentThoiTrang;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainKhach extends AppCompatActivity {
    LinearLayout fragmentchung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainkhach);

        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        fragmentchung = findViewById(R.id.fragmentchung);
        Fragment fragment = new fragmentTheThao();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
        lineartheothao.setBackground(getDrawable(R.drawable.shapemain2));


        hienfragment();


    }

    private void hienfragment() {
        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        LinearLayout linearthoitrang = findViewById(R.id.linearthoitrang);


<<<<<<< HEAD



=======
        linearda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentDa();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(linearda);

            }


        });
>>>>>>> parent of ae43dde (Revert "Hoàn thiện fragment lần 3")
        linearthoitrang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentThoiTrang();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(linearthoitrang);
            }
        });
        lineartheothao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentTheThao();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(lineartheothao);
            }
        });
<<<<<<< HEAD

=======
        linearleonui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentchung = findViewById(R.id.fragmentchung);
                Fragment fragment = new fragmentLeoNui();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentchung, fragment).commit();
                Set();
                SetColer(linearleonui);
            }
        });
>>>>>>> parent of ae43dde (Revert "Hoàn thiện fragment lần 3")
    }

    private void SetColer(LinearLayout linearLayout) {
        linearLayout.setBackground(getDrawable(R.drawable.shapemain2));
      //  linearLayout.setLayoutParams(new LinearLayout.LayoutParams(130, 65));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(CENTER);
      //  linearLayout.setPadding(5, 5, 5, 5);

        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View v = linearLayout.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.WHITE);
                ((TextView) v).setTextSize(10);

            }

        }
    }

    private void Set() {
        LinearLayout lineartheothao = findViewById(R.id.lineartheothao);
        LinearLayout linearthoitrang = findViewById(R.id.linearthoitrang);
        LinearLayout linearda = findViewById(R.id.linearda);
        LinearLayout linearleonui = findViewById(R.id.linearleonui);

        lineartheothao.setBackground(getDrawable(R.drawable.shapemain3));
        linearthoitrang.setBackground(getDrawable(R.drawable.shapemain3));
        linearda.setBackground(getDrawable(R.drawable.shapemain3));
        linearleonui.setBackground(getDrawable(R.drawable.shapemain3));

        for (int i = 0; i < lineartheothao.getChildCount(); i++) {
            View v = lineartheothao.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearthoitrang.getChildCount(); i++) {
            View v = linearthoitrang.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearda.getChildCount(); i++) {
            View v = linearda.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }
        for (int i = 0; i < linearleonui.getChildCount(); i++) {
            View v = linearleonui.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTextColor(Color.BLACK);
                ((TextView) v).setTextSize(7);
            }

        }

        lineartheothao.setOrientation(LinearLayout.VERTICAL);
        linearthoitrang.setOrientation(LinearLayout.VERTICAL);
        linearda.setOrientation(LinearLayout.VERTICAL);
        linearleonui.setOrientation(LinearLayout.VERTICAL);

    }
}