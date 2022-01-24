package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class newsmodelAdapter extends RecyclerView.Adapter<newsmodelAdapter.view_holder> {
  private ArrayList<datastoreroom>datastorerooms;
  Context context;

    public newsmodelAdapter(ArrayList<datastoreroom> datastorerooms, Context context) {
        this.datastorerooms = datastorerooms;
        this.context = context;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return new view_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull view_holder holder, int position) {
        datastoreroom newsmodel=datastorerooms.get(position);
        holder.tvnews.setText(newsmodel.getDescription());
        holder.tv1news.setText(newsmodel.getTitle());
        Picasso.get().load(newsmodel.getUrlToImage()).into(holder.ivnews);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent =new Intent(context,newsDetail.class);
                intent.putExtra("tital",newsmodel.getTitle());
                intent.putExtra("content",newsmodel.getContent());
                intent.putExtra("des",newsmodel.getDescription());
                intent.putExtra("img",newsmodel.getUrlToImage());
                intent.putExtra("url",newsmodel.getUrl());
                context.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return datastorerooms.size();
    }

    public class view_holder extends RecyclerView.ViewHolder {
        private TextView tvnews,tv1news;
        private ImageView ivnews;

        public view_holder(@NonNull View itemView) {
            super(itemView);
            tvnews=itemView.findViewById(R.id.tvnews);
            tv1news=itemView.findViewById(R.id.tv1news);
            ivnews=itemView.findViewById(R.id.ivnews);
        }
    }
}
