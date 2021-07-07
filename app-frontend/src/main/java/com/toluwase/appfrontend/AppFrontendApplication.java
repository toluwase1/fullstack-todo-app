package com.toluwase.appfrontend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppFrontendApplication.class, args);
    }

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

}


//    @Autowired
//    private RestTemplate restTemplate;

//    SignUpDto signUpDto = new SignUpDto();
//
//    var result = restTemplate.postForObject("http://localhost:8080/api/v1/signup", signUpDto, ResposeDto.class);
//
