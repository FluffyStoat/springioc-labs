package com.luxoft.springdb.lab2.dao;

import com.luxoft.springdb.lab2.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountryDao {

	void save(Country country);

	List<Country> getAllCountries();

	Country getCountryByName(String name);
}