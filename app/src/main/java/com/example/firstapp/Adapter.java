package com.example.firstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Data> models;

    public Adapter(Context context, ArrayList<Data> models){
        this.context = context;
        this.models = models;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView itemName;
        private TextView itemSurname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.name);
            itemSurname = itemView.findViewById(R.id.surname);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).
                inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).itemName.setText(models.get(position).getName());
        ((ViewHolder) holder).itemSurname.setText(models.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}