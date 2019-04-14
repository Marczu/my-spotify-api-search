import { Injectable } from '@angular/core';
import {SPOTIFY_GET_ALL_LOGS_API_URL} from "../../app.constants";
import {HttpClient} from "@angular/common/http";
import {Logs} from "../../domain/logs/Logs";

@Injectable({
  providedIn: 'root'
})
export class LogsService {

  constructor(private httpClient: HttpClient) { }

  getAllLogs(){
    return this.httpClient.get<Logs[]>(`${SPOTIFY_GET_ALL_LOGS_API_URL}`);
  }
}
