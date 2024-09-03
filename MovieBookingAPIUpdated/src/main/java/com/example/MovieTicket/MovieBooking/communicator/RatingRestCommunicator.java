package com.example.MovieTicket.MovieBooking.communicator;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingRestCommunicator {
    private final RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8081/rating/"; // Adjust the base URL as needed

    public RatingRestCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public long getRating(String id) {
        String url = baseUrl + "id/" + id;
        try {
            ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, null, Long.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new IdNotFound("Rating not found for ID: " + id);
        }
    }

    public void addRating(Map<String, Long> ratingsMap) {
        String url = baseUrl + "add";
        restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(ratingsMap), Object.class);
    }

    public void updateRating(Map<String, Long> ratingsMap) {
        String url = baseUrl + "update";
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(ratingsMap), Object.class);
    }

    public void deleteRating(String id) {
        String url = baseUrl + "id/" + id;
        try {
            restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);
        } catch (HttpClientErrorException e) {
            throw new IdNotFound("Id not found: " + id);
        }
    }
}