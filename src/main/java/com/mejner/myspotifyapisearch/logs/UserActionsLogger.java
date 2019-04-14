package com.mejner.myspotifyapisearch.logs;

import com.mejner.myspotifyapisearch.domain.logging.UserActionsLogs;
import com.mejner.myspotifyapisearch.domain.tracks.Items;
import com.mejner.myspotifyapisearch.service.UserActionsLoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Component
@Aspect
@EnableAspectJAutoProxy
public class UserActionsLogger {

    @Autowired
    UserActionsLoggerService loggerService;

    @AfterReturning(value = "execution(* com.mejner.myspotifyapisearch.controller.SearchRestController.*(..)) and args(name)")
    private void afterUserSearchForTrack(String name) {
        UserActionsLogs userLog = new UserActionsLogs();
        userLog.setLog("Użytkownik wyszukał utwór/wykonawce: " + name);
        userLog.setTimestamp(new Date());

        loggerService.saveToLogs(userLog);
    }

    @AfterReturning(value = "execution(* com.mejner.myspotifyapisearch.controller.FavoritesController.*(..)) and args(track) ")
    private void afterUserSaveFavoriteTrack(Items track) {
        UserActionsLogs userLog = new UserActionsLogs();

        userLog.setLog("Użytkownik zapisał do ulubionych utwor: " + track.getName() + " o ID: " + track.getId());
        userLog.setTimestamp(new Date());

        loggerService.saveToLogs(userLog);
    }

    @AfterReturning("execution(* com.mejner.myspotifyapisearch.controller.FavoritesController.removeFavoriteById(*)) and args(id)")
    private void afterUserRemoveFavoriteTrack(String id) {
        UserActionsLogs userLog = new UserActionsLogs();

        userLog.setLog("Użytkownik usunął utwór o id: " + id + " z listy ulubionych");
        userLog.setTimestamp(new Date());

        loggerService.saveToLogs(userLog);

        loggerService.getAllLogs().forEach(log -> {
            System.out.println(log.getTimestamp() + " " + log.getLog());
        });
    }


}
