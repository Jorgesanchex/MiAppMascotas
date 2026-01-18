package com.miapp.mascotas.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miapp.mascotas.Mascota;
import com.miapp.mascotas.MascotaAdapter;
import com.miapp.mascotas.R;

import java.util.ArrayList;
import java.util.List;

public class MascotaListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MascotaAdapter adapter;
    private List<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mascota_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewMascotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Firulais", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Bobby", R.drawable.ic_bone_empty));
        mascotas.add(new Mascota("Luna", R.drawable.ic_bone_empty));

        adapter = new MascotaAdapter(getContext(), mascotas);
        recyclerView.setAdapter(adapter);
        return view;
    }
}
