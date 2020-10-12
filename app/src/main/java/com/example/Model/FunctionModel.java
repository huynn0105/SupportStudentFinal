package com.example.Model;

public class ChucNang {
    String tenChucNang;
    int hinhAnh;

    public ChucNang(String tenChucNang, int hinhAnh) {
        this.tenChucNang = tenChucNang;
        this.hinhAnh = hinhAnh;
    }

    public String getTenChucNang() {
        return tenChucNang;
    }

    public void setTenChucNang(String tenChucNang) {
        this.tenChucNang = tenChucNang;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
