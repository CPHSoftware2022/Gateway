package com.exam.Gateway.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class EndpointController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer-service/test")
    public ResponseEntity<Object> getDataCustomerTest() {
        String url = "http://localhost:8081/test";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/customer/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id){
        String url = "http://localhost:8081/api/customer/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/customers")
    public ResponseEntity<Object> getCustomers(){
        String url = "http://localhost:8081/api/customers";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/restaurant/{id}")
    public ResponseEntity<Object> getRestaurantById(@PathVariable("id") Long id){
        String url = "http://localhost:8100/restaurant/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/restaurants")
    public ResponseEntity<Object> getRestaurants(){
        String url = "http://localhost:8100/restaurants";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/item/{id}")
    public ResponseEntity<Object> getItemById(@PathVariable("id") Long id){
        String url = "http://localhost:8100/item/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
    @GetMapping("/restaurantsItems/{id}")
    public ResponseEntity<Object> getRestaurantItems(@PathVariable("id") Long id){
        String url = "http://localhost:8100/restaurantItems/" + id;
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
