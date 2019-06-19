package com.example.diksh.horizontalrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class circleRecyclerView extends RecyclerView.Adapter<circleRecyclerView.listviewholder>  {

    List<horizontalpojo> hp;
    Context mContext;


    public circleRecyclerView(Context mContext,List<horizontalpojo> hp) {
        this.hp = hp;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public circleRecyclerView.listviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.circular_activity,null);
        circleRecyclerView.listviewholder holder=new circleRecyclerView.listviewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull circleRecyclerView.listviewholder listviewholder, final int i) {



       /* Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(i))
                .into(listviewholder.image);


*/
        horizontalpojo horizontalpojo=hp.get(i);


        listviewholder.image.setImageDrawable(mContext.getResources().getDrawable(horizontalpojo.getImgResource(),null));






    }

    @Override
    public int getItemCount() {
        return hp.size();
    }


    class listviewholder extends RecyclerView.ViewHolder{

        CircleImageView image;


        public listviewholder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.circularimage);


        }
    }
}



