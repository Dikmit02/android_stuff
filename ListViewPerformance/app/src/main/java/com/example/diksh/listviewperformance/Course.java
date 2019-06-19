package com.example.diksh.listviewperformance;

import java.util.ArrayList;
import java.util.Random;

public class Course {

    String name;
    String teachername;
    int lectures;

    public Course(String name, String teachername, int lectures) {
        this.name = name;
        this.teachername = teachername;
        this.lectures = lectures;
    }

    public String getName() {
        return name;
    }

    public String getTeachername() {
        return teachername;
    }

    public int getLectures() {
        return lectures;
    }

    public static final String[] teachers={
            "Harshit","Arnav","Prateek","Aayush","Deepak","Garima"
    };
    public static final String [] courseNames={
            "Launchpad","Crux","Android","NodeJS","Python","AngularJS"
    };
    public static ArrayList<Course> generateNRandomCourses(int n ){
        ArrayList<Course> course=new ArrayList<>();
        Random r=new Random();
        for (int i =0;i<n;i++){
            Course courses=new Course(

                    // needs teacher name ,course name and number oflectures

                    teachers[r.nextInt(6)],
                    courseNames[r.nextInt(6)],
                    10+r.nextInt(10)
            );
            course.add(courses);
        }
        return course;

    }
}
