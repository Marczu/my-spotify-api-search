package com.mejner.myspotifyapisearch.domain.tracks;

import com.mejner.myspotifyapisearch.domain.tracks.album.Album;
import com.mejner.myspotifyapisearch.domain.tracks.artists.Artists;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Items {

    @Id
    private String id;
    private String name;
    private int duration_ms;
    private Album album;
    private List<Artists> artists;

    public Items() {
        artists = new ArrayList<>();
    }

}
