import { Component, OnInit } from '@angular/core';
import {FavoritesService} from "../service/data/favorites.service";
import {Router} from "@angular/router";
import {ArtistsItems} from "../domain/artists/ArtistsItems";

@Component({
  selector: 'app-favorite-artists',
  templateUrl: './favorite-artists.component.html',
  styleUrls: ['./favorite-artists.component.css']
})
export class FavoriteArtistsComponent implements OnInit {

  favoriteArtists: ArtistsItems[] = [];

  constructor(private favoriteService: FavoritesService,
              private router: Router) {
  }

  ngOnInit() {
    this.refreshArtistsList();
  }

  refreshArtistsList() {
    this.getFavoriteArtists()
  }

  getFavoriteArtists() {
    this.favoriteService.getFavoriteArtistsByName().subscribe(
      response => {
        this.favoriteArtists = response;
        console.log(this.favoriteArtists)

      }
    )
  }


  goToSearch() {
    this.router.navigate(['search'])
  }

  removeFavoriteArtistkById(id: string) {
    this.favoriteService.removeFavoriteArtistById(id).subscribe(
      response => {
        this.refreshArtistsList()
      }
    );
  }
}
