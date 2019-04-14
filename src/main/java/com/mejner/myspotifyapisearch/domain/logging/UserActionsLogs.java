package com.mejner.myspotifyapisearch.domain.logging;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class UserActionsLogs {

    @Id
    private String id;
    private String log;
    private Date timestamp;


}
