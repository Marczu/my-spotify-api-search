package com.mejner.myspotifyapisearch.utils;

import com.mejner.myspotifyapisearch.domain.Token;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class GetApiToken {

    private String idSecret = ApiConstants.CLIENT_ID + ":" + ApiConstants.CLIENT_SECRET;
    private String idSecretEncoded = new String(Base64.encodeBase64(idSecret.getBytes()));

    public String getAccesToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED.toString());
        headers.add("Authorization", "Basic " + idSecretEncoded);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");

        HttpEntity entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Token> response =
                    restTemplate.exchange(ApiConstants.SPOTIFY_TOKEN_AUTH_URI, HttpMethod.POST,
                            entity, Token.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                response.getBody().setSucces(true);
                return response.getBody().getAccess_token();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

      return null;
    }
}
