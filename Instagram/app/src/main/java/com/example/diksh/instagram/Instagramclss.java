package com.example.diksh.instagram;
import com.parse.Parse;
import android.app.Application;

public class Instagramclss  extends Application {

    // Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("DUwoGgldIHqiilifNyASbm5TbfcyEfetKo7mjX9R")
                .clientKey("0DAPN05p7hAEdSk4SGuivIYyoH0BhPPxTe6AVry6")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}



