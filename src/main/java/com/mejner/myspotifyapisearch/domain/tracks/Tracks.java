package com.mejner.myspotifyapisearch.domain.tracks;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class Tracks {

    @Id
    private String id;
    private List<Items> items;
    private String href;
    private int total;

    public Tracks() {
        items = new ArrayList<>();
    }

}
