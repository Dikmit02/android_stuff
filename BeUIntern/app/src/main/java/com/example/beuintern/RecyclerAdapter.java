package com.example.beuintern;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
ArrayList<DataObj> lists;
LayoutInflater mLayoutInflate;
    private ListItemClicked listItemClicked;
    public interface ListItemClicked{
        void onListItemClicked(int itemClickedPos);
    }

    public RecyclerAdapter(ArrayList<DataObj> lists, Context context,ListItemClicked listItemClicked) {
        this.lists = lists;
        mLayoutInflate = LayoutInflater.from(context);
        this.listItemClicked = listItemClicked;

    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mLayoutInflate.inflate(R.layout.custom_layout, viewGroup, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder recyclerHolder, int i) {
    DataObj objs = lists.get(i);
    recyclerHolder.img.setImageResource(objs.getImgResource());
        recyclerHolder.txt.setText(objs.getTitle());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView txt;
        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.iconImage);
            txt = itemView.findViewById(R.id.textTitle);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPos = getAdapterPosition();
            listItemClicked.onListItemClicked(itemPos);
        }
    }
}
