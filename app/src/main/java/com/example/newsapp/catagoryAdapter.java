package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class catagoryAdapter extends RecyclerView .Adapter<catagoryAdapter.view_holder>{
    ArrayList<catagory>catagoryArrayList;
    Context context;
    private cat cat;

    public catagoryAdapter(ArrayList<catagory> catagoryArrayList, Context context, catagoryAdapter.cat cat) {
        this.catagoryArrayList = catagoryArrayList;
        this.context = context;
        this.cat = cat;
    }

    @NonNull
    @Override
    public view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.categori,parent,false);
        return new view_holder(view);
    }

    @Override
   public void onBindViewHolder(@NonNull view_holder holder,int position)

    {
        catagory catagory =catagoryArrayList.get(position);
        holder.idtvcategory.setText(catagory.getCategroy());
        Picasso.get().load(catagory.getCategroyImageUrl()).into(holder.idivcategory);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                cat.oncat(position);

            }
        });

    }

    @Override
    public int getItemCount() {
        return catagoryArrayList.size();
    }

    public interface cat{
        void oncat(int position);
    }

    public  class view_holder extends RecyclerView.ViewHolder {
        private ImageView idivcategory;
        private TextView idtvcategory;


        public view_holder(@NonNull View itemView) {
            super(itemView);


            idivcategory = itemView.findViewById(R.id.idivcategory);
            idtvcategory = itemView.findViewById(R.id.idtvcategory);
        }
    }
}
