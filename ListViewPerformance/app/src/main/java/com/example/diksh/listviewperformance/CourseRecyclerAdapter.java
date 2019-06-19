package com.example.diksh.listviewperformance;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHondler>{

    ArrayList<Course> courseeee;
    public CourseRecyclerAdapter(ArrayList<Course> courseeee) {
        this.courseeee = courseeee;
    }




    public CourseViewHondler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//latour inflter as we are not in activity in layoutinflater was available in adapter which was in activity class
        //adapter in seperate class and not in activity class
        LayoutInflater li=(LayoutInflater)viewGroup.
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemVIew=li.inflate(R.layout.list_item_course_card,viewGroup,false );



        return new CourseViewHondler(itemVIew);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHondler courseViewHondler, int i) {

        Course course=courseeee.get(i);
        courseViewHondler.tvlectures.setText(String.valueOf(course.getLectures()));
        courseViewHondler.tvcoursenmae.setText(course.getName());
        courseViewHondler.tvteachernmae.setText(course.getTeachername());



    }

    @Override
    public int getItemCount() {
        return courseeee.size();
    }

    class CourseViewHondler extends RecyclerView.ViewHolder{
        TextView tvcoursenmae,tvteachernmae,tvlectures;

        public CourseViewHondler(@NonNull View itemView) {
            super(itemView);
            tvcoursenmae=itemView.findViewById(R.id.tvcoursename);
            tvteachernmae=itemView.findViewById(R.id.tvteachername);
            tvlectures=itemView .findViewById(R.id.tvlecture);

        }
    }



}
