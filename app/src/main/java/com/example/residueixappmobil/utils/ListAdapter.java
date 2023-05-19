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

import java.util.ArrayList;
import java.util.List;
/**
 * Aquesta classe és un adaptador personalitzat per al RecyclerView que mostra una llista d'elements Residu.
 * Gestiona la creació de les vistes dels elements i enllaça les dades amb les vistes corresponents.
 * @author Albert Montes Miracle
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private ArrayList<Residu> mData;
    private LayoutInflater mInflater;
    private Context context;
    private List<Residu> fullList;

    /**
     * Constructor de la classe ListAdapter.
     *
     * @param itemList Llista d'elements Residu a mostrar en el RecyclerView.
     * @param context  Context de l'aplicació.
     */
    public ListAdapter(ArrayList<Residu> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.fullList = new ArrayList<>(itemList);
    }

    /**
     * Retorna el número d'elements a mostrar en el RecyclerView.
     *
     * @return Número d'elements en la llista de dades.
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }

    /**
     * Crea una nova instància de ViewHolder inflant la vista de l'element de la llista.
     *
     * @param parent   Vista pare del ViewHolder.
     * @param viewType Tipus de vista de l'element.
     * @return Nova instància de ViewHolder.
     */
    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapter.ViewHolder(view);
    }

    /**
     * Enllaça les dades de l'element en la posició especificada amb les vistes del ViewHolder.
     *
     * @param holder   ViewHolder que conté les vistes de l'element.
     * @param position Posició de l'element dins la llista.
     */
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

    /**
     * Actualitza la llista d'elements a mostrar en el RecyclerView.
     *
     * @param items Llista d'elements Residu.
     */
    public void setItems(List<Residu> items) {
        mData = (ArrayList<Residu>) items;
    }

    /**
     * Classe ViewHolder que conté les vistes de cada element de la llista.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconCardView;
        TextView tVTitolResidu;
        TextView tVDescripcioResidu;

        /**
         * Constructor de la classe ViewHolder.
         *
         * @param itemView Vista de l'element de la llista.
         */
        ViewHolder(View itemView) {
            super
                    (itemView);
            iconCardView = itemView.findViewById(R.id.iconCardView);
            tVTitolResidu = itemView.findViewById(R.id.tVTitolResidu);
            tVDescripcioResidu = itemView.findViewById(R.id.tVDescripcioResidu);
        }

        /**
         * Vincula les dades de l'element amb les vistes del ViewHolder.
         *
         * @param item Element Residu que es mostrarà a les vistes.
         */
        void bindData(final Residu item) {
            String imageURL = "http://10.2.136.45/residueix/img/residus/" + item.getImatge_residu();

            Glide.with(context).load(imageURL).into(iconCardView);
            tVTitolResidu.setText(String.valueOf(item.getNom_tipus_residu()));
            tVDescripcioResidu.setText(item.getNom_residu());
        }
    }
}

