package com.example.diksh.cbpermissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* final TextView pg=(TextView)findViewById(R.id.permissipntext);
        Button btn=(Button)findViewById(R.id.buttonpermission);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager cn=
                        (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
                NetworkInfo netinfo=cn.getActiveNetworkInfo();
                Boolean isconnected=netinfo !=null && netinfo.isConnected();
                pg.setText(isconnected?"CONNECTED":"DISCONNECTED");

            }
        });
*/


        phone=(EditText)findViewById(R.id.phone);
        Button btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check if self permission is granted or not
                int perm=ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE);
                if(perm==PackageManager.PERMISSION_GRANTED){
                    callNumber();
                }
                else{
                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{
                                    Manifest.permission.CALL_PHONE
                            },
                            121
                            );
                }

            }
        });
    }
    void callNumber(){
        String urll=phone.getText().toString();
        Uri uri=Uri.parse("tel:"+urll);
        Intent i=new Intent(Intent.ACTION_CALL,uri) ;
        startActivity(i);
    }
}
