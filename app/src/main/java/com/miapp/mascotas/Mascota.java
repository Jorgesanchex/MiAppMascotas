package com.miapp.mascotas;

public class Mascota {
    private int id;            // Identificador único
    private String nombre;
    private int imagenResId;
    private int rating;

    public Mascota(int id, String nombre, int imagenResId) {
        this.id = id;
        this.nombre = nombre;
        this.imagenResId = imagenResId;
        this.rating = 0;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getImagenResId() { return imagenResId; }
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
