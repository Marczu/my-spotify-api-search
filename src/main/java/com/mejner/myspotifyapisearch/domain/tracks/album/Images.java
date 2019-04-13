package com.mejner.myspotifyapisearch.domain.tracks.album;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Images {

    private String url;

}
