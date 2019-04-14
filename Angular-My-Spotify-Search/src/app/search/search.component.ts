import {Component, OnInit} from '@angular/core';
import {SearchService} from "../service/data/search.service";
import {Items} from "../domain/tracks/Items";
import {ArtistsItems} from "../domain/artists/ArtistsItems";
import {Artists} from "../domain/tracks/Artists";
import {FavoritesService} from "../service/data/favorites.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  tracksSearchResult: Items[] = null;
  artistsSearchResult: ArtistsItems[] = null;
  tracksName: string = "";
  artistName: string = "";

  constructor(private searchService: SearchService,
              private favoritesService: FavoritesService) {
  }

  ngOnInit() {
  }

  getArtistsNames(artists: Artists[]) {
    let resultNames = "";
    if(artists.length > 1){
      for (let i = 0; i < artists.length -1; i++) {
        resultNames += artists[i].name + ", "
      }
      resultNames += artists[artists.length-1].name
    }
    else {
      artists.forEach(art => {
        resultNames += art.name
      } );
    }
    return resultNames;
  }

  searchForTracks() {
    this.searchService.getTracksByName(this.tracksName).subscribe(
      response => {
        this.tracksSearchResult = response.items;
        this.artistsSearchResult = null;
      }
    );
  }

  searchForArtists() {
    this.searchService.getArtistsByName(this.artistName).subscribe(
      response => {
        this.artistsSearchResult = response.items;
        this.tracksSearchResult = null;
      }
    );
  }

  addTrackToFavorites(track: Items) {
    console.log(track);
    this.favoritesService.saveFavoriteTrack(track).subscribe()
  }

  msToMinutes(ms) {
    let seconds = Math.floor((ms / 1000) % 60);
    let minutes = Math.floor((ms / (1000 * 60)) % 60);

    let resultMinutes = (minutes < 10) ? "0" + minutes : minutes;
    let resultSeconds = (seconds < 10) ? "0" + seconds : seconds;

    return resultMinutes + ":" + resultSeconds;
  }


  addArtistToFavorites(artist: ArtistsItems) {
    console.log(artist);
    this.favoritesService.saveFavoriteArtist(artist).subscribe()
  }
}
