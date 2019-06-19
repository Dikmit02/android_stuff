package com.example.diksh.makeup1;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class circleRecyclerView extends  RecyclerView.Adapter<circleRecyclerView.pojoViewHolder> {

    private Context mctex;
    private List<pojo> pojoList;


    public circleRecyclerView(Context mctex, List<pojo> pojoList) {
        this.mctex = mctex;

        this.pojoList = pojoList;
    }

    @NonNull
    @Override
    public pojoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(mctex);
        View view=inflater.inflate(R.layout.circulr_layout,null);
        pojoViewHolder holder=new pojoViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull pojoViewHolder pojoViewHolder, int i) {





        pojo pojo=pojoList.get(i);
        pojoViewHolder.imageView.setImageDrawable(mctex.getResources().getDrawable(pojo.getImgResource(),null ));


    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    class pojoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;


        public pojoViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);



        }
    }
}
