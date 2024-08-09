package com.example.giangquochao_bt180724;

public class People {
    private String name;
    private String sdt;

    public People() {
    }

    public People(String name, String sdt) {
        this.name = name;
        this.sdt = sdt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Override
    public String toString() {
        return name + " - " + sdt;
    }
}
