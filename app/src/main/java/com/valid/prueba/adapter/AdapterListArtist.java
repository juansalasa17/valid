package com.valid.prueba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.valid.prueba.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import entities.ListArtist;

public class AdapterListArtist extends RecyclerView.Adapter<AdapterListArtist.OrdersCatalogHolder> implements View.OnClickListener {

    private List<ListArtist> listArtist;
    private View.OnClickListener listener;

    public AdapterListArtist(List<ListArtist> listArtist) {
        this.listArtist = listArtist;
    }

    @NonNull
    @Override
    public OrdersCatalogHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_artist, parent, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        vista.setLayoutParams(layoutParams);


        vista.setOnClickListener(this);

        return new OrdersCatalogHolder(vista);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListArtist.OrdersCatalogHolder holder, int position) {

        holder.txtNameItem.setText(listArtist.get(position).getName());
        holder.imageItem.setBackgroundResource(R.mipmap.music);
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listArtist.size();
    }


    static class OrdersCatalogHolder extends RecyclerView.ViewHolder {

        final TextView txtNameItem;
        final ImageView imageItem;

        private OrdersCatalogHolder(View itemView) {
            super(itemView);
            txtNameItem = itemView.findViewById(R.id.idNameItem);
            imageItem = itemView.findViewById(R.id.idPhoto);
        }
    }

    public void filterList(ArrayList<ListArtist> ordersFull) {

        listArtist = ordersFull;
        notifyDataSetChanged();
    }

}