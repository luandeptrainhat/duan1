package com.example.myapplication.model;

public class Product {
    private int magiay;
    private String tengiay;
    private int gia;
    private int soluong;
    private String mausac;
    private int kichco;
    private byte [] anh;
    private int maloaigiay;

    public Product(int magiay, String tengiay, int gia, int soluong, String mausac, int kichco, byte[] anh, int maloaigiay) {
        this.magiay = magiay;
        this.tengiay = tengiay;
        this.gia = gia;
        this.soluong = soluong;
        this.mausac = mausac;
        this.kichco = kichco;
        this.anh = anh;
        this.maloaigiay = maloaigiay;
    }

    public int getMagiay() {
        return magiay;
    }

    public void setMagiay(int magiay) {
        this.magiay = magiay;
    }

    public String getTengiay() {
        return tengiay;
    }

    public void setTengiay(String tengiay) {
        this.tengiay = tengiay;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getMausac() {
        return mausac;
    }

    public void setMausac(String mausac) {
        this.mausac = mausac;
    }

    public int getKichco() {
        return kichco;
    }

    public void setKichco(int kichco) {
        this.kichco = kichco;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public int getMaloaigiay() {
        return maloaigiay;
    }

    public void setMaloaigiay(int maloaigiay) {
        this.maloaigiay = maloaigiay;
    }

    @Override
    public String toString() {
        return "Product{" +
                "magiay=" + magiay +
                ", tengiay='" + tengiay + '\'' +
                ", gia=" + gia +
                ", soluong=" + soluong +
                ", mausac='" + mausac + '\'' +
                ", kichco=" + kichco +
                ", anh=" + anh +
                ", maloaigiay=" + maloaigiay +
                '}';
    }
}
