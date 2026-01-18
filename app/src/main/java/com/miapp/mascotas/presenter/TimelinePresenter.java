package com.miapp.mascotas.presenter;

import com.miapp.mascotas.api.InstagramApiService;
import com.miapp.mascotas.api.RetrofitClient;
import com.miapp.mascotas.model.MediaResponse;
import com.miapp.mascotas.view.TimelineView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimelinePresenter {

    private TimelineView view;
    private InstagramApiService api;

    public TimelinePresenter(TimelineView view){
        this.view = view;
        this.api = RetrofitClient.getClient().create(InstagramApiService.class);
    }

    public void loadMedia(String accessToken){
        api.getRecentMedia(accessToken).enqueue(new Callback<MediaResponse>() {
            @Override
            public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
                if(response.isSuccessful() && response.body() != null){
                    view.showMedia(response.body().getData());
                } else {
                    view.showError("Error al cargar medios");
                }
            }

            @Override
            public void onFailure(Call<MediaResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}
