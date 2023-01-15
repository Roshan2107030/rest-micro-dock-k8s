package com.healthy.springboot.currencyexchangeservice.repository;

import com.healthy.springboot.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

CurrencyExchange findByFromAndTo( String from, String to );


}
