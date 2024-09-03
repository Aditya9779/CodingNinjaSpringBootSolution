package org.assisment.hotel.communicator;

import org.assisment.hotel.exception.HttpsRatingServiceNotFound;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingServiceCommunicator {
    //First create the method for the restTemplate
    private final RestTemplate restTemplate;

    //Make the constructor for the making the restTemplate builder
    public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Get the id form the rating project fecting the data through the url
    public long getIdRating(String id) {
        String url = "http://localhost:8081/rating/id/";

        //It has the path variable so we add the id coming in the url in down (id)
        //Which is coming from the (String id) inside method
        /* ResponseEntity<Long> response = restTemplate.getForEntity(url + id, long.class);
        return response.getBody();*/

        /************************************************************************/
        //Second method Its has the object return value
        //Long responce = restTemplate.getForObject(url + id, long.class);

        /************************************************************************/
        //Third Method
        ResponseEntity<Long> response = restTemplate.exchange(url + id, HttpMethod.GET, null, Long.class);
        return response.getBody();
    }

    public void addFunction(Map<String, Long> ratingMap) {
        String url = "http://localhost:8081/rating/add";

        /*This is particular method for every thing like post and get ....*/
        /*restTemplate.postForObject(url, ratingMap, Object.class);*/
        /*****************************************************************************************/
        /*General method is (exachange)*/
        //If we want to check any thing just simply go through that class for the understand
        HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingMap);
        restTemplate.exchange(url, HttpMethod.POST, requestEntity, Object.class);
        //Object class is because we are not returning anything (simple the function is void)
    }


    public void updateFunction(Map<String, Long> updateRating) {
        String url = "http://localhost:8081/rating/update";
        HttpEntity<Map<String, Long>> responceEntity = new HttpEntity<>(updateRating);
        restTemplate.exchange(url, HttpMethod.PUT, responceEntity, Object.class);
    }


    public void deleteFuntion(String id) {
        String url = "http://localhost:8081/rating/id/" + id;
        try {
            restTemplate.exchange(url, HttpMethod.DELETE, null, Object.class);
        } catch (HttpClientErrorException e) {
            throw new HttpsRatingServiceNotFound(HttpStatus.valueOf(HttpStatus.NOT_FOUND.value()));
        }
    }
}
