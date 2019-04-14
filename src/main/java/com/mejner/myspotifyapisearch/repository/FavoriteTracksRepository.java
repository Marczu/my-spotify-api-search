package com.mejner.myspotifyapisearch.repository;

import com.mejner.myspotifyapisearch.domain.tracks.Items;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteTracksRepository extends CrudRepository<Items, String> {

}
