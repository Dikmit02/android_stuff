package com.example.diksh.cbdatalist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydbhelper extends SQLiteOpenHelper {
    public mydbhelper( Context context) {
        // change version wherver the schema of the database changes ie whenever a new column is add orr removed.
        // then change the databse version

        super(context, "todos.db", null, 1);

    }

    @Override
    // oncreate method is used whenever the datasbe is created for first
    public void onCreate(SQLiteDatabase db) {

    }

//call whenever the version of the database is called then called onUpgrade method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
