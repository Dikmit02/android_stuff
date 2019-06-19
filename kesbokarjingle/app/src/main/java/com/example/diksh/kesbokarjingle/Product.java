package com.example.diksh.kesbokarjingle;


public class Product {


   private String title,shortdsec,textviewshortheading;

   private int image;

    public Product( String title, String shortdsec, String textviewshortheading,  int image) {

        this.title = title;
        this.shortdsec = shortdsec;
        this.textviewshortheading = textviewshortheading;


        this.image = image;
    }



    public String getTitle() {
        return title;
    }

    public String getShortdsec() {
        return shortdsec;
    }

    public String getTextviewshortheading() {
        return textviewshortheading;
    }

    public int getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setShortdsec(String shortdsec) {
        this.shortdsec = shortdsec;
    }

    public void setTextviewshortheading(String textviewshortheading) {
        this.textviewshortheading = textviewshortheading;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
