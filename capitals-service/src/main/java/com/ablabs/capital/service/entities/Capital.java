package com.ablabs.capital.service.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Capital {
	
	private String country;	

	private String name;

	private String capital;

	private int port;
	
	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getCapital() {
		return capital;
	}
	
	/**
	 * @param capital
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}
	
	/**
	 * @return
	 */
	public int getPort() {
		return port;
	}
	
	/**
	 * @param port
	 */
	public void setPort(int port) {
		this.port = port;
	}	
}
