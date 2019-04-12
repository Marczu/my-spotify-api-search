package com.mejner.myspotifyapisearch.controller;

import com.mejner.myspotifyapisearch.domain.artists.Artists;
import com.mejner.myspotifyapisearch.domain.tracks.Tracks;
import com.mejner.myspotifyapisearch.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/search")
public class SearchRestController {

    @Autowired
    SearchService searchService;

    @GetMapping("/tracks/{name}")
    public ResponseEntity<Tracks> getTracksByName(@PathVariable String name){
        Tracks tracks = searchService.getTracksByName(name);

        if(tracks == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/artists/{name}")
    public ResponseEntity<Artists> getAlbumByName(@PathVariable String name){
        Artists artists = searchService.getArtistsByName(name);

        if(artists == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

}
