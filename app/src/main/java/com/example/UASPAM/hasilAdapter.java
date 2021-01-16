package com.example.UASPAM;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.UASPAM.model.jadwal;
import com.example.sport.R;

import java.util.ArrayList;

public class hasilAdapter extends RecyclerView.Adapter<hasilAdapter.ListViewHolder> {
    private ArrayList<jadwal> listPertandingan;

    public hasilAdapter(ArrayList<jadwal> listPertandingan) {
        this.listPertandingan = listPertandingan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row1,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        jadwal jadwal = listPertandingan.get(position);
        holder.txtTitle.setText(jadwal.getStrEvent());
        holder.txtDate.setText(jadwal.getDateEvent());
        Glide.with(holder.itemView)
                .load(jadwal.getStrThumb())
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return listPertandingan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtDate;
        ImageView imgPoster;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgPoster = itemView.findViewById(R.id.imgPoster);



        }
    }
}
