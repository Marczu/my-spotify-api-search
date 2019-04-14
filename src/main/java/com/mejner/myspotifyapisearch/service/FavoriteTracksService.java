package com.mejner.myspotifyapisearch.service;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.repository.FavoriteArtistsRepository;
import com.mejner.myspotifyapisearch.repository.FavoriteTracksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteTracksService {

    @Autowired
    FavoriteTracksRepository favoriteTracksRepository;

    public void saveFavoriteTrack(Items items){
        favoriteTracksRepository.save(items);
    }

    public Iterable<Items> findTracksFavorites(){
        return favoriteTracksRepository.findAll();
    }

    public void removeFavoriteTrackById(String id){
        favoriteTracksRepository.deleteById(id);
    }
}
