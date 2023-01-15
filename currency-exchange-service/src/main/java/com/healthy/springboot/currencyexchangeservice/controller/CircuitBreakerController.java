package com.healthy.springboot.currencyexchangeservice.controller;


import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController
{
    @GetMapping("dummy-api")
    @Retry( name= "sample-api" )
    public  String getApi()
    {

        return "dummy api";

    }

}
