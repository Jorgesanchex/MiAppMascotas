package com.miapp.mascotas.api;

import com.miapp.mascotas.model.MediaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InstagramApiService {

    @GET("users/self/media/recent/")
    Call<MediaResponse> getRecentMedia(@Query("access_token") String accessToken);
}
