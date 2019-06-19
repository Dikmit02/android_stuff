package com.example.diksh.dikshaswatch;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    LocationManager locationManager;//system se uthna
    LocationListener locationListener;//uthna
    public void updatelocation(Location location){
        Log.i("LOCATION",location.toString());


        TextView latitude=(TextView)findViewById(R.id.lattextView);
        TextView longitude=(TextView)findViewById(R.id.lontextView);
        TextView accuracy=(TextView)findViewById(R.id.accuracytextView);
        TextView altitue=(TextView)findViewById(R.id.alttextView);

        latitude.setText(String.format("Latitude: %.2f",location.getLatitude()));
        longitude.setText(String.format("Longitude: %.2f",location.getLongitude()));
        accuracy.setText(String.format("Accuracy: %.2f",location.getAccuracy()));
        altitue.setText(String.format("Altitude: %.2f",location.getAltitude()));
        Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());

        try {
            String adress="COULDNOT FIND ADDRESS";
            List<Address> addresslist=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            if(addresslist!=null&&addresslist.size()>0){
                Log.i("placeinfo",addresslist.get(0).toString());
                adress="";
                if(addresslist.get(0).getAddressLine(0)!=null){
                    adress+=addresslist.get(0).getAddressLine(0);
                }
                TextView adresstextview=(TextView)findViewById(R.id.addresstextView);
                adresstextview.setText("Address: "+adress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED){
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        locationManager=(LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
        locationListener=new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                updatelocation(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if(Build.VERSION.SDK_INT<23){
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);


        }
        else{
            if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

            }
            else{
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);

                Location location=locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if(location!=null){
                    updatelocation(location);
                }



            }
            }



    }
}
