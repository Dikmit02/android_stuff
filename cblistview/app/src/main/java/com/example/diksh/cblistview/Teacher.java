package com.example.diksh.cblistview;

import java.util.ArrayList;

public class Teacher {

    String namee;
    String course;

    public Teacher(String namee,String course) {
        this.namee = namee;
        this.course=course;
    }

    public String getNamee() {
        return namee;
    }

    public String getCourse() {
        return course;
    }


    public static ArrayList<Teacher> get8RandomTeachers(){
        ArrayList<Teacher>teachers=new ArrayList<>();
        teachers.add(new Teacher("arnav","android"));
        teachers.add(new Teacher("prateek","c++"));
        teachers.add(new Teacher("manikya","maths"));
        teachers.add(new Teacher("diksha","java"));


        return teachers;




    }
}
