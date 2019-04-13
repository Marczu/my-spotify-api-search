package com.mejner.myspotifyapisearch.repository;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.domain.tracks.Tracks;
import com.mejner.myspotifyapisearch.domain.tracks.album.Images;
import org.springframework.data.repository.CrudRepository;

public interface FavoritesRepository extends CrudRepository<Items, String> {

}
