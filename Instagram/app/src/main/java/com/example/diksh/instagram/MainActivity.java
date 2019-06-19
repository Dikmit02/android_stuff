package com.example.diksh.instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    TextView changeSignupModeextView;
    Boolean ans = true;
    EditText password;


    public void showuserlist(){
        Intent intent=new Intent(getApplicationContext(),Activityuserlist.class);
        startActivity(intent);

    }

    //it is call every time the key is pressed while typing the password
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {

        if (keyCode == event.KEYCODE_ENTER &&  event.getAction()==event.ACTION_DOWN) {
            signUp(v);
        }

        return false;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ChangeSignUpTextview) {
            Button button = (Button) findViewById(R.id.button);
            if (ans) {
                ans = false;
                button.setText("Login");
                changeSignupModeextView.setText("Or,Signup");

            } else {
                ans = true;
                button.setText("Signup");
                changeSignupModeextView.setText("Or,Login");


            }
        }
       }


    public void signUp(View view) {

        EditText username = (EditText) findViewById(R.id.username);


        if (username.getText().toString().matches("") || password.getText().toString().matches("")) {
            Toast.makeText(this, "A username or passwrd is required!!", Toast.LENGTH_SHORT).show();
        } else {
            if (ans == true) {
                ParseUser user = new ParseUser();
                user.setUsername(username.getText().toString());
                user.setPassword(password.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            Log.i("Signup", "Successful");
                            showuserlist();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {

                ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {

                        if (user != null) {
                            Log.i("Signup", "LOOOg Successful");
                            Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                            showuserlist();

                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changeSignupModeextView = (TextView) findViewById(R.id.ChangeSignUpTextview);
        changeSignupModeextView.setOnClickListener(this);
        password = (EditText) findViewById(R.id.password);
        password.setOnKeyListener(this);

        if(ParseUser.getCurrentUser()!=null){
            //alreadylogged in
            showuserlist();
        }


    }


}