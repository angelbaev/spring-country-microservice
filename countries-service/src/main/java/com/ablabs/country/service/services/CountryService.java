package com.ablabs.country.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ablabs.country.service.entities.Country;
import com.ablabs.country.service.exceptions.NotFoundException;
import com.ablabs.country.service.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	/**
	 * @return
	 */
	public List<Country> all() {
		List<Country> countries = new ArrayList<>();
		countryRepository.findAll().forEach(countries::add);
		
		return countries;
	}
		
	/**
	 * @return
	 */
	public List<Country> findByCurrency(String currency) {
		List<Country> countries = new ArrayList<>();
		countryRepository.findByCurrency(currency).forEach(countries::add);
		
		return countries;
	}

	/**
	 * @return
	 */
	public List<Country> findByCurrencysimbol(String currencysimbol) {
		List<Country> countries = new ArrayList<>();
		countryRepository.findByCurrencysimbol(currencysimbol).forEach(countries::add);
		
		return countries;
	}

	/**
	 * @return
	 */
	public List<Country> findByLanguage(String language) {
		List<Country> countries = new ArrayList<>();
		countryRepository.findByLanguage(language).forEach(countries::add);
		
		return countries;
	}

	/**
	 * @return
	 */
	public List<Country> findByCapital(String capital) {
		List<Country> countries = new ArrayList<>();
		countryRepository.findByCapital(capital).forEach(countries::add);
		
		return countries;
	}

	/**
	 * @param country
	 * @return
	 */
	public Country get(String country) {
		return countryRepository.findById(country).orElseThrow(() -> new NotFoundException("Country: " + country + " not found"));
	}
	
	/**
	 * @param entity
	 * @return
	 */
	public Country save(Country entity) {
		countryRepository.save(entity);
		
		return this.get(entity.getCountry());
	}

	/**
	 * @param country
	 * @return
	 */
	public boolean delete(String country) {
		countryRepository.deleteById(country);
		
		return true;
	}
}
