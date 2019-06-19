package com.example.diksh.listviewperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="LIST";

    ListView lvcourse;
    ArrayList<Course> couss=Course.generateNRandomCourses(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvcourse=findViewById(R.id.listviewcouse);
        CourseAdapter CourseAdapter=new CourseAdapter();
        lvcourse.setAdapter(CourseAdapter);
    }

    class CourseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return couss.size();
        }

        @Override
        public Course getItem(int position) {
            return couss.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d(TAG,"gteview "+convertView+"position "+position);
            CourseViewHolder holder;
            if(convertView==null) {

                // construct listview
                 convertView = getLayoutInflater().inflate(
                        R.layout.list_item_course,
                        parent, false
                );


                holder = new CourseViewHolder(convertView);
                //each view can have have data inside it and get using settag function
                convertView.setTag(holder);

            }
            else{
                holder=(CourseViewHolder) convertView.getTag();

            }
            Course course=getItem(position);
            holder.tvcoursenmae.setText(course.getName());
            holder.tvteachernmae.setText(course.getTeachername());
            holder.tvlectures.setText(String.valueOf(course.getLectures()));

            return convertView;
        }
        class CourseViewHolder{
            TextView tvcoursenmae,tvteachernmae,tvlectures;
            CourseViewHolder(View convertView){

                // here we are saving the refrence for the textviews once rather calling again and again
                 tvcoursenmae=convertView.findViewById(R.id.tvcoursename);
                 tvteachernmae=convertView.findViewById(R.id.tvteachername);
                 tvlectures=convertView.findViewById(R.id.tvlecture);


            }
        }
    }
}
