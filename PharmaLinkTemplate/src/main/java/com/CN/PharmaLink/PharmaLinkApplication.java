package com.CN.PharmaLink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Author(name = "Aditya Srivastava", date = "22-10-2024")
public class PharmaLinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaLinkApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
