import {Component, OnInit} from '@angular/core';
import {SearchService} from "../service/data/search.service";
import {Items} from "../domain/tracks/Items";
import {Artists} from "../domain/tracks/Artists";
import {FavoritesService} from "../service/data/favorites.service";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  searchResult: Items[] = null;
  tracksName: string = "";

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
        this.searchResult = response.items;
        console.log(this.searchResult)
      }
    );
  }

  addToFavorites(track: Items) {
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
}
