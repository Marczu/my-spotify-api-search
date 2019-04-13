package com.mejner.myspotifyapisearch.controller;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.service.FavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin()
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    FavoritesService favoritesService;

    @PostMapping("/save/track")
    public ResponseEntity<Items> saveFavoriteTrack(@RequestBody Items track){
        favoritesService.saveFavoriteTrack(track);

        favoritesService.findAllFavorites().forEach(item -> System.out.println("Wynik to: " + item.getAlbum()) );
        return new ResponseEntity<>(track, HttpStatus.OK);
    }

    @PostMapping("/save/artist")
    public ResponseEntity<com.mejner.myspotifyapisearch.domain.artists.Items> saveFavoriteArtist(@RequestBody com.mejner.myspotifyapisearch.domain.artists.Items items){
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/tracks")
    public ResponseEntity<Iterable<Items>> getFavoriteTracks(){

        Iterable<Items> tracks = favoritesService.findAllFavorites();

        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/tracks/{id}")
    public ResponseEntity removeFavoriteById(@PathVariable String id){
        favoritesService.removeFavoriteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
