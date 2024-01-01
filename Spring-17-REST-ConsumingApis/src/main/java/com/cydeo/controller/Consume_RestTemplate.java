package com.cydeo.controller;

import com.cydeo.dto.Address;
import com.cydeo.dto.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Consume_RestTemplate {

    /**
     * Rest Template it is a one method to consume to apis.
     * To able to consume, you need to use rest temp[late is providing.
     * Today we learn 3 methods.
     * 1 --> getForEntity --> exactly mapping to dto
     * 2 --> getForObject --> directly passing to my endPoint.
     * 3 --> exchange method --> we are using for passing to header items. 
     * */

    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public User[] readAllUsers(){

        ResponseEntity<User[]>  responseEntity = restTemplate.getForEntity(URI,User[].class);

        return responseEntity.getBody();

    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){

        String URL = URI + "/{id}";
        return restTemplate.getForObject(URL, Object.class,id);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumeFromDummyApi(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

        return response;
    }
}
