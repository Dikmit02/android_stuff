package com.example.diksh.horizontalrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.listviewholder> {


    List<verticalpojo> vp;
    Context mContext;
    private ListItemClicked listItemClicked;
    public interface ListItemClicked{
        void onListItemClicked(int itemClickedPos);
    }

    public RecyclerViewAdapter(Context mContext,List<verticalpojo> vp,ListItemClicked listItemClicked) {
        this.vp = vp;
        this.mContext = mContext;
        this.listItemClicked = listItemClicked;
    }

    @NonNull
    @Override
    public listviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(mContext);
        View view=inflater.inflate(R.layout.layout_listitem,null);
        listviewholder holder=new listviewholder  (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull listviewholder listviewholder, final int i) {

      /*  Glide.with(mContext)
                .asBitmap()
                .load(mImageUrls.get(i))
                .into(listviewholder.image);

 listviewholder.name.setText(mNames.get(i));
 listviewholder.image.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {


        /* if(i==0) {
             EventBus.getDefault().post(new CustomMessageEvent("Hello everyone!"));


         }
         EventBus.getDefault().post(new CustomMessageEvent("Hello everyone!"));




     }
 });*/

     verticalpojo verticalpojos=vp.get(i);


        listviewholder.image.setImageDrawable(mContext.getResources().getDrawable(verticalpojos.getmImagesUrls(),null));

        listviewholder.name.setText(verticalpojos.getmNames());




    }

    @Override
    public int getItemCount() {
        return vp.size();
    }


    class listviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView image;
        TextView name;

        public listviewholder(@NonNull View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.iamge);
            name=itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int itemPos = getAdapterPosition();
            listItemClicked.onListItemClicked(itemPos);
        }
    }


}
