import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {
  SPOTIFY_FAVORITES_GET_ALL_ARTISTS_API_URL,
  SPOTIFY_FAVORITES_GET_ALL_TRACKS_API_URL,
  SPOTIFY_FAVORITES_REMOVE_ARTIST_BY_ID_API_URL,
  SPOTIFY_FAVORITES_REMOVE_TRACK_BY_ID_API_URL,
  SPOTIFY_SAVE_ARTIST_API_URL,
  SPOTIFY_SAVE_TRACK_API_URL
} from "../../app.constants";
import {Items} from "../../domain/tracks/Items";
import {ArtistsItems} from "../../domain/artists/ArtistsItems";

@Injectable({
  providedIn: 'root'
})
export class FavoritesService {

  constructor(private httpClient: HttpClient) {
  }

  saveFavoriteTrack(track: Items) {
    return this.httpClient.post(
      `${SPOTIFY_SAVE_TRACK_API_URL}`
      , track);
  };

  saveFavoriteArtist(artist: ArtistsItems) {
    console.log("W FAV " + artist.id);
    console.log("W FAV " + artist.followers.total);
    return this.httpClient.post(
      `${SPOTIFY_SAVE_ARTIST_API_URL}`
      , artist);
  };

  getFavoriteTracksByName(){
    return this.httpClient.get<Items[]>(`${SPOTIFY_FAVORITES_GET_ALL_TRACKS_API_URL}`);
  }

  getFavoriteArtistsByName(){
    return this.httpClient.get<ArtistsItems[]>(`${SPOTIFY_FAVORITES_GET_ALL_ARTISTS_API_URL}`);
  }

  removeFavoriteById(id:string){
    return this.httpClient.delete(`${SPOTIFY_FAVORITES_REMOVE_TRACK_BY_ID_API_URL}${id}`);
  }

  removeFavoriteArtistById(id: string) {
    return this.httpClient.delete(`${SPOTIFY_FAVORITES_REMOVE_ARTIST_BY_ID_API_URL}${id}`);
  }
}

