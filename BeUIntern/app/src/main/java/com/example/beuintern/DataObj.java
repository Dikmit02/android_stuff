package com.example.beuintern;

import java.util.ArrayList;

public class DataObj {
    private int imgResource;
    private String title;
    private ArrayList<DataObjForHorizontal> arrayList;

    public DataObj(int imgResource, String title, ArrayList<DataObjForHorizontal> arrayList) {
        this.imgResource = imgResource;
        this.title = title;
        this.arrayList = arrayList;
    }

    public int getImgResource() {
        return imgResource;
    }

    public ArrayList<DataObjForHorizontal> getArrayList() {
        return arrayList;
    }

    public String getTitle() {
        return title;
    }
}
