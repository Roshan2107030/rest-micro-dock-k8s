package com.healthy.springboot.currencyexchangeservice.controller;

import com.healthy.springboot.currencyexchangeservice.bean.CurrencyExchange;
import com.healthy.springboot.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
public class CurrencyExchangeController {



    @Autowired
    private CurrencyExchangeRepository curRepo;

    @Autowired
    private Environment env;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue( @PathVariable String from,
                                                   @PathVariable String to )
    {

       // CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange= curRepo.findByFromAndTo(from, to);


        if (currencyExchange == null) {

            throw new RuntimeException("unable to find: "+from+" to: "+to);
        }

        String port = env.getProperty("local.server.port");
        String host= env.getProperty("HOSTNAME");
        String version= "v12";

        currencyExchange.setEnvironment(port + " " + version + " " + host);
        return currencyExchange;
    }



}
