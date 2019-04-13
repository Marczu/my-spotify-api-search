import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SPOTIFY_SEARCH_API_URL} from "../../app.constants";
import {BaseSearch} from "../../domain/tracks/BaseSearch";

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private httpClient: HttpClient) { }

  getTracksByName(name: string){
    return this.httpClient.get<BaseSearch>(`${SPOTIFY_SEARCH_API_URL}tracks/` + name);
  }
}
