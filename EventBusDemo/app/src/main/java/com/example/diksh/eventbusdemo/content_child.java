package com.example.diksh.eventbusdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class content_child extends AppCompatActivity {
    EditText messageEditText;
    Button triggerEventbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_child);
        messageEditText=(EditText)findViewById(R.id.editText);
        triggerEventbutton=(Button)findViewById(R.id.button);

        triggerEventbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String usertext=messageEditText.getText().toString()
;
            CustomMessageEvent event=new CustomMessageEvent();
            event.setCustomMessage(usertext);
                EventBus.getDefault().post(event);
                finish();
            }
        });
    }
}
