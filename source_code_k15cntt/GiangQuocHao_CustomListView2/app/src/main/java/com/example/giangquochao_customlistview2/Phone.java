package com.example.giangquochao_customlistview2;

public class Phone {
    private int imagePhone;
    private String namePhone;

    public Phone(String namePhone, int imagePhone) {
        this.namePhone = namePhone;
        this.imagePhone = imagePhone;
    }

    public int getImagePhone() {
        return imagePhone;
    }

    public void setImagePhone(int imagePhone) {
        this.imagePhone = imagePhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }
}
