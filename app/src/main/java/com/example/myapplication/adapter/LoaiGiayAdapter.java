package com.example.myapplication.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.dao.LoaiGiayDAO;
import com.example.myapplication.model.LoaiGiay;

import java.util.ArrayList;

public class LoaiGiayAdapter extends RecyclerView.Adapter<LoaiGiayAdapter.ViewHolder> {
    private Context context;
    private ArrayList<LoaiGiay> list;
    private LoaiGiayDAO dao;
    int maloai;

    public LoaiGiayAdapter(Context context, ArrayList<LoaiGiay> list, LoaiGiayDAO dao) {
        this.context = context;
        this.list = list;
        this.dao = dao;
    }

    //
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.item_loaigiay, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtTenloai.setText(list.get(position).getTenloai());

        holder.btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogSua(list.get(holder.getAdapterPosition()));
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTenloai;
        LinearLayout btnSua;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenloai = itemView.findViewById(R.id.txtTenLoaiGiay);
            btnSua = itemView.findViewById(R.id.btnSua);
        }
    }

    private void showDialogSua(LoaiGiay loaiGiay) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_sualoaigiay, null);
        builder.setView(view);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        EditText edttenloaigiay = view.findViewById(R.id.edttenloaiGiaySua);
        Button btnSua = view.findViewById(R.id.btnSua);
        Button btnXoa = view.findViewById(R.id.btnXoa);

        edttenloaigiay.setText(loaiGiay.getTenloai());
        maloai = loaiGiay.getMaloai();
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenloai = edttenloaigiay.getText().toString();
                LoaiGiay loaiGiay1 = new LoaiGiay(loaiGiay.getMaloai(), tenloai);
                if (dao.suaLoaiGiay(loaiGiay1)) {
                    getDS();
                    alertDialog.dismiss();
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (dao.xoaloaiGiay(maloai)) {
                    getDS();
                    alertDialog.dismiss();
                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getDS() {
        list.clear();
        list = dao.getDSLOAI();
        notifyDataSetChanged();
    }
}
