package com.springboot.microservices.CurrencyExchangeService.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.microservices.CurrencyExchangeService.entity.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	CurrencyExchange findByFromAndTo(String from, String to);
}
