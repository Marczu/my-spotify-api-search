package com.mejner.myspotifyapisearch.domain.artists;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class ArtistsItems {

    @Id
    private String id;
    private String name;
    private Followers followers;
    private List<Images> images;

    public ArtistsItems() {
        images = new ArrayList<>();
    }
}
