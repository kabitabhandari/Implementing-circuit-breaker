package com.example.clientcircuitbreaker;

public class CircuitBreakerOpenException extends RuntimeException{
    public CircuitBreakerOpenException(String message, Throwable cause){
        super(message, cause);
    }
}
