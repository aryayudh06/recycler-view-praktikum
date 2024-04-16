package com.pam.tokpedd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BarangAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<BarangModel> barang;
    private BarangItemClickListener itemClickListener;

    public BarangAdapter(Context context, ArrayList<BarangModel> barang, BarangItemClickListener listener){
        this.context = context;
        this.barang = barang;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_card, parent, false);

        return new BarangViewHolder(view, this.itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BarangModel b = this.barang.get(position);
        BarangViewHolder vh =(BarangViewHolder) holder;
        vh.tvBarang.setText(b.getBarang().toString());
        vh.tvHarga.setText(b.getHarga().toString());
        vh.ivBarang.setImageResource(b.getImage());
    }

    @Override
    public int getItemCount() {
        return barang.size();
    }

    public static class BarangViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHarga, tvBarang;
        private ImageView ivBarang;
        private ImageButton ibDelete;
        public BarangViewHolder(@NonNull View itemView, BarangItemClickListener listener) {
            super(itemView);
            this.tvBarang = itemView.findViewById(R.id.tvBarang);
            this.tvHarga = itemView.findViewById(R.id.tvHarga);
            this.ivBarang = itemView.findViewById(R.id.ivGambar);
            this.ibDelete = itemView.findViewById(R.id.ibDelete);
            ibDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemDelete(position);
                        }
                    }
                }
            });
        }

    }


}


