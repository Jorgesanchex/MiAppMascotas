package com.miapp.mascotas;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MascotaAdapter adapter;
    private List<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista de mascotas Hardcodeadas
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Firulais", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Bobby", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Luna", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Milo", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Nala", R.drawable.ic_bone_empty));

        adapter = new MascotaAdapter(this, mascotas);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_star) {
            startActivity(new Intent(this, FavoritesActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
