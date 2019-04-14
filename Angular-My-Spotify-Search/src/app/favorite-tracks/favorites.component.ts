import {Component, OnInit} from '@angular/core';
import {FavoritesService} from "../service/data/favorites.service";
import {Items} from "../domain/tracks/Items";
import {Artists} from "../domain/tracks/Artists";
import {Router} from "@angular/router";
import {ArtistsItems} from "../domain/artists/ArtistsItems";

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrls: ['./favorites.component.css']
})
export class FavoritesComponent implements OnInit {

  favoriteTracks: Items[] = [];


  constructor(private favoriteService: FavoritesService,
              private router: Router) {
  }

  ngOnInit() {
    this.refreshTrackList();
  }

  refreshTrackList() {
    this.getFavoriteTracks()
  }

  getFavoriteTracks() {
    this.favoriteService.getFavoriteTracksByName().subscribe(
      response => {
        this.favoriteTracks = response
        console.log(this.favoriteTracks)
      }
    )
  }

  removeFavoriteTrackById(id: string) {
    this.favoriteService.removeFavoriteById(id).subscribe(
      response => {
        this.refreshTrackList()
      }
    );

  }

  getArtistsNames(artists: Artists[]) {
    let resultNames = "";
    if (artists.length > 1) {
      for (let i = 0; i < artists.length - 1; i++) {
        resultNames += artists[i].name + ", "
      }
      resultNames += artists[artists.length - 1].name
    }
    else {
      artists.forEach(art => {
        resultNames += art.name
      });
    }
    return resultNames;
  }

  msToMinutes(ms) {
    let seconds = Math.floor((ms / 1000) % 60);
    let minutes = Math.floor((ms / (1000 * 60)) % 60);

    let resultMinutes = (minutes < 10) ? "0" + minutes : minutes;
    let resultSeconds = (seconds < 10) ? "0" + seconds : seconds;

    return resultMinutes + ":" + resultSeconds;
  }

  goToSearch() {
    this.router.navigate(['search'])
  }
}
