package com.mejner.myspotifyapisearch.service;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {

    @Autowired
    FavoritesRepository favoritesRepository;

    public void saveFavoriteTrack(Items items){
        favoritesRepository.save(items);
    }

    public Iterable<Items> findAllFavorites(){
        return favoritesRepository.findAll();
    }

    public void removeFavoriteById(String id){
        favoritesRepository.deleteById(id);
    }
}
