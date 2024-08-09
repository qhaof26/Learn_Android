package com.example.giangquochao_lvcb2;

public class People {
    private String id;
    private String fullName;
    private String sex;

    public People(String id, String fullName, String sex) {
        this.id = id;
        this.fullName = fullName;
        this.sex = sex;
    }

    public People() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return id + " - " + fullName + " - " + sex;
    }
}
