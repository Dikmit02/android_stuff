package com.example.diksh.databasedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase mydatabase=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            //User is the name of the databse
            //MODEPRIVATE to us ethe databse within the data
            //null (special erroe catching method)
            //putting table in th databse

            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS tablename (name VARCHAR, age int(3))");
           /* mydatabase.execSQL("INSERT INTO tablename(name,age) VALUES('Diksha',21)");

            mydatabase.execSQL("INSERT INTO tablename(name,age)VALUES('kanika',100)");

            mydatabase.execSQL("INSERT INTO tablename(name,age)VALUES('manikya',15)");

            mydatabase.execSQL("INSERT INTO tablename(name,age)VALUES('seema',48)");*/

            //cursor to take out the values from the database
            //cursor allowa us to loop through a query and get the results from it


            Cursor c=mydatabase.rawQuery("SELECT * FROM tablename WHERE name='Diksha'",null);
            //for colus
            int nameIndex=c.getColumnIndex("name");
            int ageIndex=c.getColumnIndex("age");


            c.moveToFirst();//diksha 21
            while(c!=null){
                // c is null if
                //mydatabase.execSQL("INSERT INTO tablename(name,age) VALUES('Diksha',21)");

                //mydatabase.execSQL("INSERT INTO tablename(name,age)VALUES('kanika',23)");
                //are not written
                // here the code will run twice one for diksha nad one fro kanika
                 Log.i("nameeee",c.getString(nameIndex));
                 Log.i("ageeee",Integer.toString(c.getInt(ageIndex)));
                 c.moveToNext();



            }





        }


        catch(Exception e) {
            e.printStackTrace();

        }








    }
}
