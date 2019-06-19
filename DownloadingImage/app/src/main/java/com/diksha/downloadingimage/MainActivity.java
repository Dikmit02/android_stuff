package com.diksha.downloadingimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView downloadedimag;
    public void downloadimage(View view){
        //http://www.polkadotpassport.com/wp-content/uploads/2015/10/IMG_0691.jpg
       // Log.i("interaction","button tagged")
        ImageDownloader task= new ImageDownloader();
        Bitmap myimage;
        try {
            myimage = task.execute("https://upload.wikimedia.org/wikipedia/en/a/aa/Bart_Simpson_200px.png").get();
            downloadedimag.setImageBitmap(myimage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        downloadedimag =(ImageView)findViewById(R.id.imageView);

    }




    public class ImageDownloader extends AsyncTask<String,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls )
        {
            try {
                URL url=new URL(urls[0]);
                HttpURLConnection coonection=(HttpURLConnection)url.openConnection();
                coonection.connect();
                // down;oad img in one go and then convert to bitmap
                InputStream inputstream = coonection.getInputStream();
                Bitmap mybitmap=BitmapFactory.decodeStream(inputstream);
                return mybitmap;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
