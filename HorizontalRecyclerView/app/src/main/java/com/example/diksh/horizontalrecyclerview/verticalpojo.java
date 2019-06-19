package com.example.diksh.horizontalrecyclerview;

import java.util.ArrayList;

public class verticalpojo {


    private String mNames;

    private int mImageUrls;
    private ArrayList<horizontalpojo> arrayList;


    public String getmNames() {
        return mNames;
    }

    public void setmNames(String mNames) {
        this.mNames = mNames;
    }


 public int getmImagesUrls() {
     return mImageUrls;
 }

    public void setmImageUrls(int mImageUrls) {
        this.mImageUrls = mImageUrls;
    }
    public ArrayList<horizontalpojo> getArrayList() {
        return arrayList;
    }


    public verticalpojo(Integer mImageUrls,String mNames,ArrayList<horizontalpojo> arrayList) {
        this.mNames = mNames;
        this.mImageUrls = mImageUrls;
        this.arrayList = arrayList;


    }
}
