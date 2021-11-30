package com.example.clientcircuitbreaker;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;

@Service
@Slf4j
public class InfoService {
    private final String serverEndpoint = "http://localhost:8080/info";
    private RestTemplate restTemplate;

    @Autowired
    public InfoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @CircuitBreaker(name = "serviceInfoCircuitBreaker", fallbackMethod = "fallbackProcess")
    public String getServiceInfo() throws Exception {

        if(true){
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Entire thing blew up");
            throw new Exception("Nothing found", fileNotFoundException);
        }


        return restTemplate.getForObject(serverEndpoint,String.class);

    }
    public String fallbackProcess(Throwable throwable) {
       throw new CircuitBreakerOpenException("Fallback method has been called from circuit breaker implementation" , throwable);

    }


}
