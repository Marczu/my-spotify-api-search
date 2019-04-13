package com.mejner.myspotifyapisearch.controller;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.domain.tracks.Tracks;
import com.mejner.myspotifyapisearch.domain.tracks.album.Images;
import com.mejner.myspotifyapisearch.repository.FavoritesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FavoritesController {

    @Autowired
    FavoritesRepository repository;

    @PostMapping("/favoritesTracks")
    public ResponseEntity<Items> sendImages(@RequestBody Items items){
        repository.save(items);

        repository.findAll().forEach(item -> System.out.println("Wynik to: " + item.getAlbum().getName()) );
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
