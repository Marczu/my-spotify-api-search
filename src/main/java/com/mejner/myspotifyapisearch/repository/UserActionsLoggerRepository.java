package com.mejner.myspotifyapisearch.repository;

import com.mejner.myspotifyapisearch.domain.logging.UserActionsLogs;
import org.springframework.data.repository.CrudRepository;

public interface UserActionsLoggerRepository extends CrudRepository<UserActionsLogs, String> {
}
