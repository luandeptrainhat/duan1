package com.example.myapplication.model;

import java.util.Arrays;

public class ItemGioHang {
    String ten;
    int gia;
    int soLuong;
    String mauSac;
    byte [] anh ;

    public ItemGioHang(String ten, int gia, int soLuong, String mauSac, byte[] anh) {
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    @Override
    public String toString() {
        return "ItemGioHang{" +
                "ten='" + ten + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", mauSac='" + mauSac + '\'' +
                ", anh=" + Arrays.toString(anh) +
                '}';
    }
}
