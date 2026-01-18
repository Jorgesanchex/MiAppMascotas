package com.miapp.mascotas.view;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.miapp.mascotas.R;
import com.miapp.mascotas.model.Media;
import com.miapp.mascotas.presenter.TimelinePresenter;

import java.util.List;

public class TimelineActivity extends AppCompatActivity implements TimelineView {

    private RecyclerView recyclerView;
    private TimelinePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        recyclerView = findViewById(R.id.recyclerViewTimeline);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new TimelinePresenter(this);
        String accessToken = "TU_ACCESS_TOKEN"; // Coloca tu token de sandbox
        presenter.loadMedia(accessToken);
    }

    @Override
    public void showMedia(List<Media> mediaList) {
        MediaAdapter adapter = new MediaAdapter(mediaList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
