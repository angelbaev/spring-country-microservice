package com.ablabs.country.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ablabs.country.service.entities.Country;

public interface CountryRepository extends JpaRepository <Country, String> {

	/**
	 * @param currency
	 * @return
	 */
	public List<Country> findByCurrency(String currency);
	
	/**
	 * @param currencysimbol
	 * @return
	 */
	public List<Country> findByCurrencysimbol(String currencysimbol);

	/**
	 * @param language
	 * @return
	 */
	public List<Country> findByLanguage(String language);

	/**
	 * @param capital
	 * @return
	 */
	public List<Country> findByCapital(String capital);
}
