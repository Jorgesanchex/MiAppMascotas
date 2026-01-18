package com.miapp.mascotas;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaViewHolder extends RecyclerView.ViewHolder {

    ImageView ivImagen, ivBone;
    TextView tvNombre, tvRating;

    public MascotaViewHolder(View itemView) {
        super(itemView);
        ivImagen = itemView.findViewById(R.id.ivImagen);
        ivBone = itemView.findViewById(R.id.ivBone);
        tvNombre = itemView.findViewById(R.id.tvNombre);
        tvRating = itemView.findViewById(R.id.tvRating);
    }
}
