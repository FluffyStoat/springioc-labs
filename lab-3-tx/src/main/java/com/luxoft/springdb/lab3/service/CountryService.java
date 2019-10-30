package com.luxoft.springdb.lab3.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;

import com.luxoft.springdb.lab3.model.Country;

public interface CountryService {

    List<Country> getAllCountriesInsideTransaction(Propagation propagation);

    List<Country> getAllCountriesRequired();

    List<Country> getAllCountriesRequiresNew();

    List<Country> getAllCountriesSupports();

    List<Country> getAllCountriesNever();

    List<Country> getAllCountriesMandatory();

    List<Country> getAllCountriesNotSupported();

    List<Country> getAllCountries();
}
