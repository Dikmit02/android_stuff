package com.example.diksh.parseproject;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

import android.app.Application;

public class App extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EDHbTVQvzbrGPonDWFxAdj8zTERLNAveDXe0ctJy")
                .clientKey("jY1R2TKjiNVY9e2QBOhHoYxJlDgVXKVV1upI9Suq")
                .server("https://parseapi.back4app.com/")
                .build()
        );


    }
}
