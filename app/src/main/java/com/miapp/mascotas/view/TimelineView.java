package com.miapp.mascotas.view;

import com.miapp.mascotas.model.Media;
import java.util.List;

public interface TimelineView {
    void showMedia(List<Media> mediaList);
    void showError(String message);
}
