package com.example.UASPAM;


import com.example.UASPAM.model.hasilResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/json/1/eventspastleague.php")
    Call<hasilResponse> getPlayingSport(@Query("id") String id);
}
