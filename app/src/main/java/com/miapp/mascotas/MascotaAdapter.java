package com.miapp.mascotas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaViewHolder> {

    private List<Mascota> mascotas;
    private Context context;

    public MascotaAdapter(Context context, List<Mascota> mascotas) {
        this.context = context;
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mascota, parent, false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRating.setText(String.valueOf(mascota.getRating()));
        holder.ivImagen.setImageResource(mascota.getImagenResId());

        // Cambiar ícono del hueso según rating
        holder.ivBone.setImageResource(mascota.getRating() > 0 ? 
            R.drawable.ic_bone_filled : R.drawable.ic_bone_empty);

        // Incrementar rating al tocar el hueso
        holder.ivBone.setOnClickListener(v -> {
            mascota.setRating(mascota.getRating() + 1);
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() { return mascotas.size(); }
}
