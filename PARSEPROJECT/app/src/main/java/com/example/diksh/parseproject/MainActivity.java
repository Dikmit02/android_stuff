package com.example.diksh.parseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import android.app.Application;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ParseUser.logOut();
        if(ParseUser.getCurrentUser()!=null){
            Log.i("Currnetuser ","userloggedin"+ParseUser.getCurrentUser().getUsername());
        }
        else{
            Log.i("Currnetuser ","user not loggedin")  ;
        }



    }
}




/*
        /*ParseObject score=new ParseObject("Score");
        score.put("username","rob");
        score.put("score",86);
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Log.i("save successful","successful");

                }
                else{
                    Log.i("SAVEinbackground","failed Eroor:"+e.toString());
                }
            }
        });
        //ktm
        ParseQuery<ParseObject>query=ParseQuery.getQuery("Score");
        query.getInBackground("rOZt6TfKuq", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {

                if(e==null&&object!=null){

                    //for updating the value on the server
                    object.put("score",200);
                    object.saveInBackground();


                    Log.i("objectvalue",object.getString("username"));
                    Log.i("objectvalue",Integer.toString(object.getInt("score")));
                }//ktm
            }
        });



        ParseObject tweet =new ParseObject("Tweet");
        tweet.put("Username","Diksha");
        tweet.put("Tweet","hi, i am twitter");
        tweet.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Log.i("save successful","successful");

                }
                else{
                    Log.i("SAVEinbackground","failed Eroor:"+e.toString());
                }
            }
        });

    ParseQuery<ParseObject>query=ParseQuery.getQuery("Tweet");
        query.getInBackground("p891EeJ5I8", new GetCallback<ParseObject>() {
@Override
public void done(ParseObject object, ParseException e) {

        if(e==null&&object!=null){

        for updating the value on the server


        object.put("Username","Kanika");
        object.put("Tweet","hiiiii");
        object.saveInBackground();



                   Log.i("valuee",object.getString("Username"));
                    Log.i("value",object.getString("Tweet"));
        }
        }
        });



        geeting the values from hte databse
         ParseQuery<ParseObject> query =ParseQuery.getQuery("Score");

        query.whereGreaterThan("score",250);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if(e==null){
                    Log.i("findInBackground","Retrieved"+objects.size()+" objects");// size
                    if(objects.size()>0){
                        for(ParseObject object:objects){
                            object.put("score",(object.getInt("score")+50));
                            object.saveInBackground();
                            Log.i("findINBackgroundResult",Integer.toString(object.getInt("score")));

                        }
                    }
                }
            }
        });


            FOR SINGNUP

        ParseUser user=new ParseUser();
        user.setUsername("diksha");
        user.setPassword("mypaswd");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {

                if(e==null){
                    Log.i("signup","successfully");

                }
                else{
                    Log.i("signup","unsuccessfuly ");
                }
            }
        });

         FOR LOGGIN
           ParseUser.logInInBackground("diksha", "wrong", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user!=null){
                    Log.i("login","successful");
                }
                else{
                    Log.i("login","failed"+e.toString());
                }
            }
        });




         GET CURRENT USER
         if(ParseUser.getCurrentUser()!=null){
            Log.i("Currnetuser ","userloggedin"+ParseUser.getCurrentUser().getUsername());
        }
        else{
            Log.i("Currnetuser ","user not loggedin")  ;
        }



        */
