package com.ablabs.country.service.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import com.ablabs.country.service.entities.Country;
import com.ablabs.country.service.services.CountryService;

@RestController
public class CountryController {
	
	HashMap<Integer, Integer> timePort=new HashMap<>();

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/")
	public List<Country> getAll() {
		return countryService.all();
	}
	
	@GetMapping("/{country}")
	public Country getCountry(@PathVariable String country) {
		Country  countryEnitity = countryService.get(country);
		int port = Integer.parseInt(environment.getProperty("local.server.port")) ;
		int time = timePort.getOrDefault(port, 0);

		countryEnitity.setPort(port);
		
		if (time >= 0) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return countryEnitity;			
	}
	
	@GetMapping("/time/{time}")
	public int getTime(@PathVariable int time) {
		int port = Integer.parseInt(environment.getProperty("local.server.port")) ;
		timePort.put(port, time);
		
		return time;
	}	
}
