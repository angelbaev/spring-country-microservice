package com.ablabs.capital.service.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ablabs.capital.service.entities.Capital;

@FeignClient(name="countries-service-simple",url="http://localhost:8000/")
public interface CapitalServiceProxySimple {
	@GetMapping("/")
	public List<Capital> getAllCountries();

	@GetMapping("/{country}")
	public Capital getCountry(@PathVariable("country") String country);
}
