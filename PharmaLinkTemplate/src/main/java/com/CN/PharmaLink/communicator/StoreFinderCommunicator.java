package com.CN.PharmaLink.communicator;


import com.CN.PharmaLink.dto.MedicalStoreDto;
import com.CN.PharmaLink.exceptions.HttpStoreFinderServiceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StoreFinderCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public StoreFinderCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<MedicalStoreDto> getNearestMedicalStores(Long userId, Long distance, String jwtToken) {
        String url = "http://localhost:8082/storefinder/user/getNearestMedicalStores/" + userId + "/" + distance;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new HttpStoreFinderServiceNotFound(e.getStatusCode());
        }
    }

    public List<MedicalStoreDto> getMedicalStoresWithMedicine(String medicine, String jwtToken) {
        String url = "http://localhost:8082/storefinder/user/getStoresWithMedicine/" + medicine;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + jwtToken);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        try {
            ResponseEntity<List> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, List.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            throw new HttpStoreFinderServiceNotFound(e.getStatusCode());
        }
    }

    public void addMedicalStore(MedicalStoreDto storeDto) {
        String url = "http://localhost:8082/storefinder/store/add";
        HttpEntity<MedicalStoreDto> requestEntity = new HttpEntity<>(storeDto);

        restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
    }

    public void updateMedicalStore(MedicalStoreDto storeDto) {
        String url = "http://localhost:8082/storefinder/store/update";
        HttpEntity<MedicalStoreDto> requestEntity = new HttpEntity<>(storeDto);

        restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Object.class);
    }

    public void deleteMedicalStore(String id) {
        String url = "http://localhost:8082/storefinder/store/delete/" + id;

        try {
            restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);
        } catch (HttpClientErrorException e) {
            throw new HttpStoreFinderServiceNotFound(e.getStatusCode());
        }
    }
}
