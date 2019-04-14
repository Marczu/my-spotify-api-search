package com.mejner.myspotifyapisearch.service;

import com.mejner.myspotifyapisearch.domain.artists.ArtistsItems;
import com.mejner.myspotifyapisearch.repository.FavoriteArtistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteArtistsService {

    @Autowired
    FavoriteArtistsRepository favoriteArtistsRepository;

    public void saveFavoriteArtist(ArtistsItems items){
        favoriteArtistsRepository.save(items);
    }

    public Iterable<ArtistsItems> findArtistsFavorites(){
        return favoriteArtistsRepository.findAll();
    }

    public void removeFavoriteArtistById(String id){
        favoriteArtistsRepository.deleteById(id);
    }

}
