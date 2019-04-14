import {Component, OnInit} from '@angular/core';
import {Logs} from "../domain/logs/Logs";
import {LogsService} from "../service/data/logs.service";

@Component({
  selector: 'app-logs',
  templateUrl: './logs.component.html',
  styleUrls: ['./logs.component.css']
})
export class LogsComponent implements OnInit {

  logsList: Logs[] = [];

  constructor(private logsService: LogsService) {
  }

  ngOnInit() {
    this.refreshLogs()
  }

  refreshLogs() {
    this.getAllLogs()
    console.log(this.logsList.forEach(log => {
      log.log
    }))
  }

  getAllLogs() {
    this.logsService.getAllLogs().subscribe(
      response => {
        this.logsList = response;
      }
    )
  }
}
