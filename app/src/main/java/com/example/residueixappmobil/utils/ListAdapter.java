package com.example.residueixappmobil.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.ListElement;
import com.example.residueixappmobil.model.Residu;


import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Residu> mData;
    private LayoutInflater mInflater;
    private Context context;
    private List<Residu> fullList;


    public ListAdapter(ArrayList<Residu> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.fullList = new ArrayList<>(itemList);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));

        holder.itemView.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(mData.get(position).getNom_tipus_residu());
            builder.setMessage(mData.get(position).getDescripcio_residu());
            builder.setPositiveButton("OK", null);
            builder.show();
        });
    }


    public void setItems(List<Residu> items) {
        mData = (ArrayList<Residu>) items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iconCardView;
        TextView tVTitolResidu;
        TextView tVDescripcioResidu;


        ViewHolder (View itemView){
            super(itemView);
            iconCardView = itemView.findViewById(R.id.iconCardView);
            tVTitolResidu = itemView.findViewById(R.id.tVTitolResidu);
            tVDescripcioResidu = itemView.findViewById(R.id.tVDescripcioResidu);
        }

        void bindData(final Residu item){
            String imageURL = "http://10.2.136.45/residueix/img/residus/"+item.getImatge_residu();

            Glide.with(context).load(imageURL).into(iconCardView);
            tVTitolResidu.setText(String.valueOf(item.getNom_tipus_residu()));
            tVDescripcioResidu.setText(item.getNom_residu()) ;
        }
    }
}
