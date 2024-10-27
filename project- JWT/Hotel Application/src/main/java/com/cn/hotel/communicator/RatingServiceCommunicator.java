package com.cn.hotel.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cn.hotel.dto.RatingResponse;
import com.cn.hotel.exceptions.HttpRatingServiceNotFound;


@Service
public class RatingServiceCommunicator {


	private final RestTemplate restTemplate;

	@Autowired
	public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate=restTemplateBuilder.build();
	}

	public RatingResponse getRating(String id, String jwtToken)
	{
		String url ="http://localhost:8081/rating/id/";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + jwtToken);

		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<RatingResponse> ratingResponse = restTemplate.exchange(url+id,HttpMethod.GET,requestEntity,RatingResponse.class);

		return ratingResponse.getBody();
	}

	public void addRating(Map<String, Long> ratingsMap) {

		String url ="http://localhost:8081/rating/add";

		//restTemplate.postForObject(url, ratingsMap, Object.class);
		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);

		restTemplate.exchange(url,HttpMethod.POST,requestEntity,Object.class);
	}

	public void updateRating(Map<String, Long> ratingsMap)
	{
		String url ="http://localhost:8081/rating/update";

		HttpEntity<Map<String, Long>> requestEntity = new HttpEntity<>(ratingsMap);

		restTemplate.exchange(url,HttpMethod.PUT,requestEntity,Object.class);
	}

	public void deleteRating(String id)
	{
		String url ="http://localhost:8081/rating/remove/id/";

		try {
			restTemplate.exchange(url+id,HttpMethod.DELETE,null,Object.class);
		}
		catch(HttpClientErrorException e)
		{
			throw new HttpRatingServiceNotFound(HttpStatus.NOT_FOUND);
		}


	}

}
