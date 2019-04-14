import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ErrorComponent} from "./error/error.component";
import {SearchComponent} from "./search/search.component";
import {FavoritesComponent} from "./favorite-tracks/favorites.component";
import {HomeComponent} from "./home/home.component";
import {LogsComponent} from "./logs/logs.component";
import {FavoriteArtistsComponent} from "./favorite-artists/favorite-artists.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'search', component: SearchComponent},
  {path: 'favoriteTracks', component: FavoritesComponent},
  {path: 'favoriteArtists', component: FavoriteArtistsComponent},
  {path: 'logs', component: LogsComponent},
  {path: '**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
