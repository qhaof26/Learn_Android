package com.example.giangquochao_190724;

public class SanPham {
    private String masp;
    private String tensp;
    private float donGia;

    public SanPham(String masp, String tensp, float donGia) {
        this.masp = masp;
        this.tensp = tensp;
        this.donGia = donGia;
    }

    public SanPham() {
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return tensp;
    }
}
