package com.example.a26_giangquochao_ltdnt_21103101456;

public class sing {
    private String nameSong;
    private String nameSing;

    public sing(String nameSong, String nameSing) {
        this.nameSong = nameSong;
        this.nameSing = nameSing;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSing() {
        return nameSing;
    }

    public void setNameSing(String nameSing) {
        this.nameSing = nameSing;
    }

    @Override
    public String toString() {
        return nameSong + " - " + nameSing;
    }
}
