package com.miapp.mascotas.api.deserializers;

import com.google.gson.*;
import com.miapp.mascotas.model.Media;
import java.lang.reflect.Type;

public class MediaDeserializer implements JsonDeserializer<Media> {
    @Override
    public Media deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        String id = obj.get("id").getAsString();
        String imageUrl = obj.getAsJsonObject("images")
                .getAsJsonObject("standard_resolution")
                .get("url").getAsString();
        int likes = obj.getAsJsonObject("likes").get("count").getAsInt();
        return new Media(id, imageUrl, likes);
    }
}
