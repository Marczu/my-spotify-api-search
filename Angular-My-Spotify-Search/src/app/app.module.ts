import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorComponent } from './error/error.component';
import { SearchComponent } from './search/search.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { FavoritesComponent } from './favorite-tracks/favorites.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LogsComponent } from './logs/logs.component';
import { FavoriteArtistsComponent } from './favorite-artists/favorite-artists.component';

@NgModule({
  declarations: [
    AppComponent,
    ErrorComponent,
    SearchComponent,
    FavoritesComponent,
    HeaderComponent,
    HomeComponent,
    LogsComponent,
    FavoriteArtistsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
