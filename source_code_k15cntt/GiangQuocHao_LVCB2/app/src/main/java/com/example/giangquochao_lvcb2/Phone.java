package com.example.giangquochao_lvcb2;

public class Phone {
    private String fullName;
    private String numbersPhone;

    public Phone() {
    }

    public Phone(String fullName, String numbersPhone) {
        this.fullName = fullName;
        this.numbersPhone = numbersPhone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumbersPhone() {
        return numbersPhone;
    }

    public void setNumbersPhone(String numbersPhone) {
        this.numbersPhone = numbersPhone;
    }

    @Override
    public String toString() {
        return fullName + " - " + numbersPhone;
    }
}
