package com.example.servercircuitbreaker;

import org.springframework.stereotype.Service;

@Service
public class InfoService {
    String serviceInfoIs = "Hi, this message is from Springboot Service";

    public String getServiceInfo() {
        return serviceInfoIs;
    }
}
