package com.mejner.myspotifyapisearch.service;

import com.mejner.myspotifyapisearch.domain.logging.UserActionsLogs;
import com.mejner.myspotifyapisearch.repository.UserActionsLoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActionsLoggerService {

    @Autowired
    UserActionsLoggerRepository userActionsLogger;

    public void saveToLogs(UserActionsLogs logToSave){
        userActionsLogger.save(logToSave);
    }

    public Iterable<UserActionsLogs> getAllLogs(){
        return userActionsLogger.findAll();
    }

}
