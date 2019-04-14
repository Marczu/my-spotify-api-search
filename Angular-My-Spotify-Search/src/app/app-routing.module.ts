import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ErrorComponent} from "./error/error.component";
import {SearchComponent} from "./search/search.component";
import {FavoritesComponent} from "./favorites/favorites.component";
import {HomeComponent} from "./home/home.component";
import {LogsComponent} from "./logs/logs.component";

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'search', component: SearchComponent},
  {path: 'favorites', component: FavoritesComponent},
  {path: 'logs', component: LogsComponent},
  {path: '**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
