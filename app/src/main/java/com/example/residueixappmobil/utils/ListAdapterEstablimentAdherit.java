package com.example.residueixappmobil.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.residueixappmobil.R;
import com.example.residueixappmobil.model.EstablimentAdherit;


import java.util.ArrayList;
import java.util.List;

public class ListAdapterEstablimentAdherit extends RecyclerView.Adapter<ListAdapterEstablimentAdherit.ViewHolder> {
    private ArrayList<EstablimentAdherit> mData;
    private LayoutInflater mInflater;
    private Context context;
    private List<EstablimentAdherit> fullList;

    /**
     * Constructor de la classe ListAdapter.
     *
     * @param itemList Llista d'elements Residu a mostrar en el RecyclerView.
     * @param context  Context de l'aplicació.
     */
    public ListAdapterEstablimentAdherit(ArrayList<EstablimentAdherit> itemList, Context context) {
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
    public ListAdapterEstablimentAdherit.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_element, null);
        return new ListAdapterEstablimentAdherit.ViewHolder(view);
    }


    /**
     * Enllaça les dades de l'element en la posició especificada amb les vistes del ViewHolder.
     *
     * @param holder   ViewHolder que conté les vistes de l'element.
     * @param position Posició de l'element dins la llista.
     */
    @Override
    public void onBindViewHolder(final ListAdapterEstablimentAdherit.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));

        holder.itemView.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(mData.get(position).getNom_establiment());
            builder.setMessage(mData.get(position).getNom_poblacio());
            builder.setPositiveButton("OK", null);
            builder.show();
        });
    }

    /**
     * Actualitza la llista d'elements a mostrar en el RecyclerView.
     *
     * @param items Llista d'elements Residu.
     */
    public void setItems(List<EstablimentAdherit> items) {
        mData = (ArrayList<EstablimentAdherit>) items;
    }

    /**
     * Classe ViewHolder que conté les vistes de cada element de la llista.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconCardView;
        TextView tvEstablimentAdherit;
        TextView tVdescripcioEstablimentAdherit;

        /**
         * Constructor de la classe ViewHolder.
         *
         * @param itemView Vista de l'element de la llista.
         */
        ViewHolder(View itemView) {
            super(itemView);
            iconCardView = itemView.findViewById(R.id.iconCardView);
            tvEstablimentAdherit = itemView.findViewById(R.id.tVTitolResidu);
            tVdescripcioEstablimentAdherit = itemView.findViewById(R.id.tVDescripcioResidu);
        }

        /**
         * Vincula les dades de l'element amb les vistes del ViewHolder.
         *
         * @param item Element Residu que es mostrarà a les vistes.
         */
        void bindData(final EstablimentAdherit item) {
            String imageURL = "http://10.2.136.45/residueix/img/residus/" + item.getImatge();

            Glide.with(context).load(imageURL).into(iconCardView);
            tvEstablimentAdherit.setText(String.valueOf(item.getNom_establiment()));
            tVdescripcioEstablimentAdherit.setText(item.getNom_provincia());
        }
    }
}
