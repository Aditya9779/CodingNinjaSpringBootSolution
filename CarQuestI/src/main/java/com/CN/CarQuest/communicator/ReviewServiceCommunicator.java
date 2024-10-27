package com.CN.CarQuest.communicator;


import com.CN.CarQuest.dto.ReviewRequest;
import com.CN.CarQuest.dto.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReviewServiceCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public ReviewServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Method to add a review
    public void addReview(ReviewRequest reviewRequest, String jwtToken) {
        String url = "http://localhost:8082/review/add";  // Replace with Review Service URL

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        HttpEntity<ReviewRequest> requestEntity = new HttpEntity<>(reviewRequest, headers);
        restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);
    }

    // Method to get reviews by car name
    public List<ReviewResponse> getReview(String carName, String jwtToken) {
        String url = "http://localhost:8082/review/car/" + carName;  // Replace with Review Service URL

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);

        return response.getBody();
    }
}
