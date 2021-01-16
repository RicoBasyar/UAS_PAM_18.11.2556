package com.example.UASPAM;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.UASPAM.model.hasil;
import com.example.sport.R;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.ListViewHolder> {
    private ArrayList<hasil> listPertandingan;

    public JadwalAdapter(ArrayList<hasil> listPertandingan) {
        this.listPertandingan = listPertandingan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        hasil sport = listPertandingan.get(position);

        holder.txtTitle.setText(sport.getStrEvent());
        holder.txtHome.setText(sport.getStrHomeTeam());
        holder.txtHomeScore.setText(sport.getIntHomeScore());
        holder.txtAway.setText(sport.getStrAwayTeam());
        holder.txtAwayScore.setText(sport.getIntAwayScore());
        holder.txtDate.setText(sport.getDateEvent());
        holder.txtImageHidden.setText(sport.getStrThumb());
        Glide.with(holder.itemView)
                .load(sport.getStrThumb())
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return listPertandingan.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtHome;
        TextView txtHomeScore;
        TextView txtAway;
        TextView txtAwayScore;
        TextView txtDate;
        TextView txtImageHidden;
        ImageView imgPoster;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtHome =  itemView.findViewById(R.id.txtHome);
            txtHomeScore =  itemView.findViewById(R.id.txtHomeScore);
            txtAway = itemView.findViewById(R.id.txtAway);
            txtAwayScore = itemView.findViewById(R.id.txtAwayScore);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtImageHidden = itemView.findViewById(R.id.txtimg);
            imgPoster = itemView.findViewById(R.id.imgPoster);

            Button button = itemView.findViewById(R.id.btnDetail);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(), DetailActivity.class);

                    intent.putExtra("title", txtTitle.getText().toString());
                    intent.putExtra("Home", txtHome.getText().toString());
                    intent.putExtra("HomeScore", txtHomeScore.getText().toString());
                    intent.putExtra("Away", txtAway.getText().toString());
                    intent.putExtra("AwayScore", txtAwayScore.getText().toString());
                    intent.putExtra("Date", txtDate.getText().toString());
                    intent.putExtra("img", txtImageHidden.getText().toString());

                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}

