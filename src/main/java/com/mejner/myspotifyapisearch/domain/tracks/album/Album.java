package com.mejner.myspotifyapisearch.domain.tracks.album;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Album {

    private String name;
    private String release_date;
    private String total_tracks;
    private String type;
    private List<Images> images;

    public Album() {
        images = new ArrayList<>();
    }
}
