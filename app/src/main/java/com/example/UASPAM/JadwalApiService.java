package com.example.UASPAM;

import com.example.UASPAM.model.jadwalResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JadwalApiService {
    @GET("api/v1/json/1/eventsnextleague.php")
    Call<jadwalResponse> getPlayingNextSport(@Query("id") String id);
}
