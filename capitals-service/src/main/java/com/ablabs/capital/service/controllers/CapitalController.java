package com.ablabs.capital.service.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ablabs.capital.service.entities.Capital;
import com.ablabs.capital.service.services.CapitalServiceProxy;
import com.ablabs.capital.service.services.CapitalServiceProxySimple;

@RestController
public class CapitalController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CapitalServiceProxy proxy;
	
	@Autowired
	private CapitalServiceProxySimple simpleProxy;
	
	HashMap<Integer, Integer> httpPort = new HashMap<>();	
	
	@GetMapping("/")
	public List<Capital> getAllCountries() {
		List<Capital> response = proxy.getAllCountries();
		logger.info("CapitalesService -> {} ", response);

		return response;
	}
	
	@GetMapping("/{country}")
	public Capital getCountry(@PathVariable String country) {
		Capital response = proxy.getCountry(country);
		httpPort.put(response.getPort(), httpPort.getOrDefault(response.getPort(), 0) + 1);
		logger.info("CapitalesService -> {} ", response);

		return response;
	}
	
	@GetMapping("/ports")
	public String getCountryUsingFeign() {
		StringBuffer response = new StringBuffer();
		httpPort.forEach((k, v) -> response.append(" Port: " + k + " Value: " + v));
		
		return response.toString();
	}
	
	@GetMapping("/template/{country}")
	public Capital getCountryUsingRestTemplate(@PathVariable String country) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("country", country);		
		
		ResponseEntity<Capital> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/{country}", 
				Capital.class, 
				uriVariables );
		
		Capital response = responseEntity.getBody();
		
		return response;
	}

	@GetMapping("/feign/{country}")
	public Capital getCountryUsingFeign(@PathVariable String country) {
		Capital response = simpleProxy.getCountry(country);	

		return response;
	}
}
