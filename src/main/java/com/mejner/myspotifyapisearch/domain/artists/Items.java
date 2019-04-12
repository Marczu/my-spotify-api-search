package com.mejner.myspotifyapisearch.domain.artists;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Items {

    private String name;
    private Followers followers;
    private List<Images> images;

    public Items() {
        images = new ArrayList<>();
    }
}
