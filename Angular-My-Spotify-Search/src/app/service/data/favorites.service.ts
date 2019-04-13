import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {
  SPOTIFY_FAVORITES_GET_ALL_TRACKS_API_URL, SPOTIFY_FAVORITES_REMOVE_TRACK_BY_ID_API_URL,
  SPOTIFY_SAVE_TRACK_API_URL,
  SPOTIFY_SEARCH_API_URL
} from "../../app.constants";
import {Items} from "../../domain/tracks/Items";
import {BaseSearch} from "../../domain/tracks/BaseSearch";

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

  getFavoriteTracksByName(){
    return this.httpClient.get<Items[]>(`${SPOTIFY_FAVORITES_GET_ALL_TRACKS_API_URL}`);
  }

  removeFavoriteById(id:string){
    return this.httpClient.delete(`${SPOTIFY_FAVORITES_REMOVE_TRACK_BY_ID_API_URL}${id}`);
  }

}

