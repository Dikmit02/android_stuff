package com.example.diksh.cblistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Teacher> teachers=Teacher.get8RandomTeachers();
    ListView lvteacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvteacher=(ListView)findViewById(R.id.lvTeachers);
        TeacherAdapter teacherAdapter=new TeacherAdapter();
        lvteacher.setAdapter(teacherAdapter);



      /*  String[] names=new String[]{
                "arnav", "Prateek",
                "deepak","garima",
                "rishabh","harshit",
                "aayush",
                "rajesh",
                "arnav",
                "Prateek",
                "deepak",
                "garima",
                "rishabh",
                "harshit",
                "aayush",
                "rajesh",
                "gygyg"
        };
        ListView lvnames=(ListView)findViewById(R.id.lvNames);

        ArrayAdapter<String>namesapadpter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);
        lvnames.setAdapter(namesapadpter);
        */
         }
         class TeacherAdapter extends BaseAdapter{

             @Override
             public int getCount() {
                 //size if arraylist return
                 return teachers.size();
             }

             @Override
             public Teacher getItem(int position) {
                 //each item that is used to create ech roe of list
                 //obj of type obj
                 return teachers.get(position);
             }

             @Override
             public long getItemId(int position) {
                 //ech item ie ech row of list
                 //
                 return 0;
             }

             @Override
             public View getView(int position, View convertView, ViewGroup parent) {
                 // each layout is created
                 // create new resource file

                 View itemview=getLayoutInflater().inflate(

                         R.layout.list_item_teacher,
                         parent,
                         false
                 );
                 TextView tvname=itemview.findViewById(R.id.tvname);
                 TextView tvcourse=itemview.findViewById(R.id.tvcourse);
                 tvname.setText(getItem(position).getNamee());
                 tvcourse.setText(getItem(position).getCourse());

                 return null;
             }
         }
}
