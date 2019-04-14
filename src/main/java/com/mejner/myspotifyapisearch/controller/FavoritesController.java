package com.mejner.myspotifyapisearch.controller;

import com.mejner.myspotifyapisearch.domain.artists.ArtistsItems;
import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.service.FavoriteArtistsService;
import com.mejner.myspotifyapisearch.service.FavoriteTracksService;
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
    FavoriteTracksService favoriteTracksService;

    @Autowired
    FavoriteArtistsService favoriteArtistsService;

    @PostMapping("/save/track")
    public ResponseEntity<Items> saveFavoriteTrack(@RequestBody Items track){
        favoriteTracksService.saveFavoriteTrack(track);

        System.out.println("zapisano utwór " + track.getName());

        return new ResponseEntity<>(track, HttpStatus.OK);
    }

    @PostMapping("/save/artist")
    public ResponseEntity<ArtistsItems> saveFavoriteArtist(@RequestBody ArtistsItems items){

        favoriteArtistsService.saveFavoriteArtist(items);
        System.out.println("zapisano artyste " + items.getName());
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/tracks")
    public ResponseEntity<Iterable<Items>> getFavoriteTracks(){
        Iterable<Items> tracks = favoriteTracksService.findTracksFavorites();

        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/artists")
    public ResponseEntity<Iterable<ArtistsItems>> getFavoriteArtists(){
//        Iterable<ArtistsItems> tracks = favoriteTracksService.findTracksFavorites();
        Iterable<ArtistsItems> artists = favoriteArtistsService.findArtistsFavorites();
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @DeleteMapping("/delete/tracks/{id}")
    public ResponseEntity removeFavoriteTrackById(@PathVariable String id){
        favoriteTracksService.removeFavoriteTrackById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/artists/{id}")
    public ResponseEntity removeFavoriteArtistById(@PathVariable String id){
        favoriteArtistsService.removeFavoriteArtistById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
