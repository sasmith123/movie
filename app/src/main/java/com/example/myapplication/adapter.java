package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.Viewholder1> {
    private List<layout2> listitems2;
    private Context context;

    public adapter(List<layout2> listitems2, Context context) {
        this.listitems2 = listitems2;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Viewholder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout2,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder1 holder, int position) {
     layout2 listitem2 = listitems2.get(position);
     holder.Head.setText(listitem2.getHead1());
     holder.Desc.setText(listitem2.getDesc1());
        Picasso.with(context)
                .load("https://image.tmdb.org/t/p/w500"+listitem2.getImageurl1())
                .into(holder.image2);
    }

    @Override
    public int getItemCount() {
        return listitems2.size();
    }

    public class Viewholder1 extends RecyclerView.ViewHolder {
        public TextView Head,Desc;
       public ImageView image2;
       public RecyclerView itemRecycler;
        public Viewholder1(@NonNull View itemView) {
            super(itemView);
            Head=itemView.findViewById(R.id.Head);
            Desc=itemView.findViewById(R.id.Desc);
            image2=itemView.findViewById(R.id.image2);
            itemRecycler=itemView.findViewById(R.id.item_recycler);
        }
    }
}