package com.example.UASPAM;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sport.R;
import com.example.UASPAM.model.jadwalResponse;
import com.example.UASPAM.model.jadwal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PertandinganMendatangFragment extends Fragment {

    private ArrayList<jadwal> listjadwal;
    private RecyclerView rvJadwal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pertandingan_mendatang, container, false);
        rvJadwal = view.findViewById(R.id.rv_jadwal);
        rvJadwal.setHasFixedSize(true);
        rvJadwal.setLayoutManager(new LinearLayoutManager(getContext()));

        JadwalApiService service = ApiClient.getRetrofitInstance().create(JadwalApiService.class);
        Call<jadwalResponse> call = service.getPlayingNextSport("4328");
        call.enqueue(new Callback<jadwalResponse>() {
            @Override
            public void onResponse(Call<jadwalResponse> call, Response<jadwalResponse> response) {

                listjadwal = response.body().getEvents();

                hasilAdapter hasilAdapter = new hasilAdapter(listjadwal);
                rvJadwal.setAdapter(hasilAdapter);
            }

            @Override
            public void onFailure(Call<jadwalResponse> call, Throwable t) {

            }
        });



        return view;
    }
}