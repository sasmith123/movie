package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Viewholder> {
   private List<row_item> listitems;
   private Context context;

    public RecyclerAdapter(List<row_item> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View V=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item,parent,false);
        return new Viewholder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
    row_item listitem = listitems.get(position);
    holder.textViewHead.setText(listitem.getHead());
    holder.textViewDesc.setText(listitem.getDesc());
        Picasso.with(context)
        .load("https://image.tmdb.org/t/p/w500"+listitem.getImageUrl())
        .into(holder.imageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{
        public TextView textViewHead,textViewDesc;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            textViewHead=(TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc=(TextView)itemView.findViewById(R.id.textViewDesc);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linearLayout);
        }

    }

}
