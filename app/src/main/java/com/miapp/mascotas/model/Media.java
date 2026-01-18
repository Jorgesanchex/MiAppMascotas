package com.miapp.mascotas.model;

public class Media {
    private String id;
    private String imageUrl;
    private int likes;

    public Media(String id, String imageUrl, int likes){
        this.id = id;
        this.imageUrl = imageUrl;
        this.likes = likes;
    }

    public String getId() { return id; }
    public String getImageUrl() { return imageUrl; }
    public int getLikes() { return likes; }
}
