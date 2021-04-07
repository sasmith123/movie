package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainrecyclerviewAdapter extends RecyclerView.Adapter<MainrecyclerviewAdapter.MainViewHolder> {
    private Context context;
    private List<category> categorylist;


    public MainrecyclerviewAdapter(Context context, List<category> categorylist) {
        this.context = context;
        this.categorylist = categorylist;
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.allcategory,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        category listitem =categorylist.get(position);
    holder.categoryTitle.setText(listitem.getCategoryTitle());
    setCatItemRecycler(holder.itemRecycler,categorylist.get(position).getlistitems2());
    }

    @Override
    public int getItemCount() {
        return categorylist.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView categoryTitle;
        RecyclerView itemRecycler;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle =itemView.findViewById(R.id.cat_title);
            itemRecycler= itemView.findViewById(R.id.item_recycler);
        }
    }
    private void setCatItemRecycler(RecyclerView itemRecycler,List<layout2> listitems2){
        adapter adapter =new adapter(listitems2, context);
        itemRecycler.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        itemRecycler.setAdapter(adapter);
    }
}
