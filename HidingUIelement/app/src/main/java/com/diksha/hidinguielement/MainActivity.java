package com.diksha.hidinguielement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    Button hide;
    Button show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView) findViewById(R.id.textView);
        hide=(Button) findViewById(R.id.hidebutton);
        show=(Button) findViewById(R.id.showbutton);
        hide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // View list = (View)findViewById(R.id.myviewId);
                text.setVisibility(View.INVISIBLE);

            }
        });
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // View list = (View)findViewById(R.id.myviewId);
                text.setVisibility(View.VISIBLE);

            }
        });


    }
}
