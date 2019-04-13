package com.mejner.myspotifyapisearch.domain.tracks.artists;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Artists {

    private String name;

}
