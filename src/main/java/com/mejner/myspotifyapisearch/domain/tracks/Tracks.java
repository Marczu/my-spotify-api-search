package com.mejner.myspotifyapisearch.domain.tracks;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Tracks {

    private List<Items> items;
    private String href;
    private int total;

    public Tracks() {
        items = new ArrayList<>();
    }

}
