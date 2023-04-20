package com.example.residueixappmobil.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.ListElement;


import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
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

        holder.itemView.setOnClickListener(view -> Toast.makeText(context, "Card #" + position + " clicked", Toast.LENGTH_SHORT).show());
    }

    public void setItems(List<ListElement> items) {
        mData = items;
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

        void bindData(final ListElement item){
            iconCardView.clearColorFilter();
            tVTitolResidu.setText(String.valueOf(item.getTipus()));
            tVDescripcioResidu.setText(item.getDescripcio()) ;
        }
    }
}
