package com.example.classworkfive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter{

    ArrayList<Items> itemsList = new ArrayList<>();
    Context context;

    public Adapter(ArrayList<Items> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rawitem, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ViewHolder)holder).textname.setText(itemsList.get(position).getItemName());
        ((ViewHolder)holder).textprice.setText(itemsList.get(position).getItemPrice() + "") ;
        ((ViewHolder)holder).img.setImageResource(itemsList.get(position).getItemImg());

    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textname, textprice;
        View v;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            img = v.findViewById(R.id.itemImg);
            textname = v.findViewById(R.id.itemName);
            textprice = v.findViewById(R.id.itemPrice);

        }
    }

}
