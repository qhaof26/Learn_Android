package com.example.giangquochao_230724;

public class HoaQUa {
    private int idImage;
    private String nameHq;
    private float price;

    public HoaQUa(int idImage, String nameHq, float price) {
        this.idImage = idImage;
        this.nameHq = nameHq;
        this.price = price;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getNameHq() {
        return nameHq;
    }

    public void setNameHq(String nameHq) {
        this.nameHq = nameHq;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
