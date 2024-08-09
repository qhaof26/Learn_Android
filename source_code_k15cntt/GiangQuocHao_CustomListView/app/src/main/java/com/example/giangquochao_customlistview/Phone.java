package com.example.giangquochao_customlistview;

public class Phone {
    private int idImagePhone;
    private String namePhone;

    public Phone(int idImagePhone, String namePhone) {
        this.idImagePhone = idImagePhone;
        this.namePhone = namePhone;
    }

    public int getIdImagePhone() {
        return idImagePhone;
    }

    public void setIdImagePhone(int idImagePhone) {
        this.idImagePhone = idImagePhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    @Override
    public String toString() {
        return idImagePhone + " - " + namePhone;
    }
}
