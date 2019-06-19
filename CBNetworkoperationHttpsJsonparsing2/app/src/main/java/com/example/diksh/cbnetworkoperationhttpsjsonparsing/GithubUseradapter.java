package com.example.diksh.cbnetworkoperationhttpsjsonparsing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GithubUseradapter extends RecyclerView.Adapter<GithubUseradapter.GithubViewHolder> {

    ArrayList<GithubUser> githubgithub;

    public GithubUseradapter(ArrayList<GithubUser> githubgithub) {
        this.githubgithub = githubgithub;
    }


    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View v=layoutInflater.inflate(R.layout.item_row,viewGroup,false );
        return new GithubViewHolder(v);





    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder viewHolder, int i) {
        String login=githubgithub.get(i).login;
        String url=githubgithub.get(i).html_url;
        Double score=githubgithub.get(i).score;
        String avatar_url=githubgithub.get(i).avatar_url;

        viewHolder.tvViewLogin.setText(login);
        viewHolder.tvViewUrl.setText(url);
        viewHolder.tvViewScore.setText(String.valueOf(score));
        Picasso.get().load(avatar_url).into(viewHolder.imageViewProfile);




    }

    @Override
    public int getItemCount() {
        return githubgithub.size();
    }

    public class GithubViewHolder extends RecyclerView.ViewHolder {
        TextView tvViewLogin,tvViewUrl,tvViewScore;
        ImageView imageViewProfile;
        public GithubViewHolder(View v) {
            super(v);
            tvViewLogin=v.findViewById(R.id.tvViewLogin);
            tvViewUrl=v.findViewById(R.id.tvViewUrl);
            tvViewScore=v.findViewById(R.id.tvViewScore);
            imageViewProfile=v.findViewById(R.id.imageViewProfile);


        }
    }
}
