package com.example.giangquochao260824;

public class Music {
    private String singer;
    private String song;

    public Music(String singer, String song) {
        this.singer = singer;
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return song + " - " + singer;
    }
}
