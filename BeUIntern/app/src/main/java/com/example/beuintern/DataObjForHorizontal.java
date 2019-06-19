package com.example.beuintern;

public class DataObjForHorizontal {
    private int imgResource;
    private String title;

    public DataObjForHorizontal(int imgResource, String title) {
        this.imgResource = imgResource;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getImgResource() {
        return imgResource;
    }
}
