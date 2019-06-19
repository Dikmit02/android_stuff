package com.example.diksh.cbweb;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="my fisrt app";
    EditText var1,var2,url;
    Button btn;
    ImageButton btnbrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        var1=(EditText)findViewById(R.id.var1);
        var2=(EditText)findViewById(R.id.var2);
        btn=(Button)findViewById(R.id.button);
        url=(EditText)findViewById(R.id.url);
        btnbrowser=(ImageButton)findViewById(R.id.imageButton);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int v1=Integer.parseInt(var1.getText().toString());
                int v2=Integer.parseInt(var2.getText().toString());
                int v3=v1+v2;

                Intent i=new Intent(getApplicationContext(),Main2Activity.class );
                i.putExtra("result",v3);
                startActivity(i);




            }
        });

        btnbrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String urll=url.getText().toString();

                Uri uri=Uri.parse(urll);
                Intent i=new Intent(Intent.ACTION_VIEW,uri);

                try {
                    startActivity(i);
                }
                catch(ActivityNotFoundException anfe){

                    Log.e(TAG,"Could not open activity with given url",anfe);

                }

            }
        });

        }
}
