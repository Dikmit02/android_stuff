package com.example.diksh.listviewperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;



public class RecyclerActivity extends AppCompatActivity {
    public static final String TAG="RV";
    ArrayList<Course> coursess=Course.generateNRandomCourses(100);
    RecyclerView rvCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        rvCourses=findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new GridLayoutManager(this,4,
                LinearLayoutManager.HORIZONTAL,
                false




        ));

        //com.example.diksh.listviewperformance.CourseRecyclerAdapter courseRecyclerAdapter=com.example.diksh.listviewperformance.CourseRecyclerAdapter(coursess);
        CourseRecyclerAdapter courseRecyclerAdapter= new CourseRecyclerAdapter(coursess);
        rvCourses.setAdapter(courseRecyclerAdapter);



    }
}
