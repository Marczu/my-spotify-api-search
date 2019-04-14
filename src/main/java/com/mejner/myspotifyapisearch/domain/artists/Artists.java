package com.mejner.myspotifyapisearch.domain.artists;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artists {

    private List<ArtistsItems> items;

    public Artists() {
        items = new ArrayList<>();
    }
}
