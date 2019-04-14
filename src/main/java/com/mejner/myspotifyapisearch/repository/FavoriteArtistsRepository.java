package com.mejner.myspotifyapisearch.repository;

import com.mejner.myspotifyapisearch.domain.artists.ArtistsItems;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteArtistsRepository extends CrudRepository<ArtistsItems, String> {
}
