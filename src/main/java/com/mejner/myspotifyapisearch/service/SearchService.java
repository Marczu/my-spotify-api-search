package com.mejner.myspotifyapisearch.service;

import com.mejner.myspotifyapisearch.domain.artists.Artists;
import com.mejner.myspotifyapisearch.domain.artists.ArtistsSearchResult;
import com.mejner.myspotifyapisearch.domain.tracks.TracksSearchResult;
import com.mejner.myspotifyapisearch.domain.tracks.Tracks;
import com.mejner.myspotifyapisearch.utils.ApiConstants;
import com.mejner.myspotifyapisearch.utils.GetApiToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SearchService {

    @Autowired
    GetApiToken getApiToken;

    public Tracks getTracksByName(String name) {

        RestTemplate restTemplate = new RestTemplate();

        /*Setting headers*/
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", ApiConstants.SPOTIFY_JWT_PREFIX + getApiToken.getAccesToken());

        log.info(getApiToken.getAccesToken());

        HttpEntity entity = new HttpEntity<>(headers);

        log.info(ApiConstants.SPOTIFY_SEARCH_URL + name + "&type=track");

        try {
            ResponseEntity<TracksSearchResult> response =
                    restTemplate.exchange(ApiConstants.SPOTIFY_SEARCH_URL + trimName(name) + "&type=track&market=US", HttpMethod.GET,
                            entity, TracksSearchResult.class);
            log.info("status: " + response.getStatusCode());

            /*For testing*/
//            response.getBody().getTracks().getItems().forEach(item -> System.out.println("Tytuł to: " + item.getName() +
//                    " Album to: " + item.getAlbum().getName() +
//                    " Image Url: " + item.getAlbum().getImages().get(0)));
//            response.getBody().getTracks().getItems().forEach(item -> item.getArtist().forEach(
//                    artists -> System.out.println("Artysta to: " + artists.getName())) );
//            response.getBody().getTracks().getItems().forEach(item -> item.getArtists().forEach(artist -> System.out.println("Artysta to :" + artist.getName())));

            if (response.getStatusCode().is2xxSuccessful() && response.getBody().getTracks().getItems().size() != 0) {
                return response.getBody().getTracks();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Artists getArtistsByName(String name) {

        RestTemplate restTemplate = new RestTemplate();

        /*Setting headers*/
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept", "application/json");
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", ApiConstants.SPOTIFY_JWT_PREFIX + getApiToken.getAccesToken());

        log.info(getApiToken.getAccesToken());

        HttpEntity entity = new HttpEntity<>(headers);

        log.info(ApiConstants.SPOTIFY_SEARCH_URL + name + "&type=artist");

        try {
            ResponseEntity<ArtistsSearchResult> response =
                    restTemplate.exchange(ApiConstants.SPOTIFY_SEARCH_URL + trimName(name) + "&type=artist&market=US", HttpMethod.GET,
                            entity, ArtistsSearchResult.class);
            log.info("status: " + response.getStatusCode());

            /*For testing*/
//            System.out.println(response.getBody().getArtists().getItems().get(0).getName());
//            response.getBody().getArtists().getItems().forEach(item -> item.getImages().forEach(image -> System.out.println(image.getUrl())));

            if (response.getStatusCode().is2xxSuccessful() && response.getBody().getArtists().getItems().size() != 0) {
                return response.getBody().getArtists();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String trimName(String name){
        String result = name.trim().replace(" ", "%20");
        return result;
    }
}
