package com.miapp.mascotas;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MascotaAdapter adapter;
    private List<Mascota> favoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerViewFavorites);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        favoritos = new ArrayList<>();
        favoritos.add(new Mascota("Firulais", R.drawable.ic_bone_filled));
        favoritos.add(new Mascota("Bobby", R.drawable.ic_bone_filled));
        favoritos.add(new Mascota("Luna", R.drawable.ic_bone_filled));
        favoritos.add(new Mascota("Milo", R.drawable.ic_bone_filled));
        favoritos.add(new Mascota("Nala", R.drawable.ic_bone_filled));

        adapter = new MascotaAdapter(this, favoritos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
