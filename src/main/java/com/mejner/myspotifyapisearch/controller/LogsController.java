package com.mejner.myspotifyapisearch.controller;

import com.mejner.myspotifyapisearch.domain.logging.UserActionsLogs;
import com.mejner.myspotifyapisearch.service.UserActionsLoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
@RequestMapping("/api/logs")
public class LogsController {

    @Autowired
    UserActionsLoggerService logsService;

    @GetMapping()
    public ResponseEntity<Iterable<UserActionsLogs>> getAllUserLogs() {
        Iterable<UserActionsLogs> logs = logsService.getAllLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}
