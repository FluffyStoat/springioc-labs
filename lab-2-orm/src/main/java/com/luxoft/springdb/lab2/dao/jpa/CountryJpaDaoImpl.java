package com.luxoft.springdb.lab2.dao.jpa;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.luxoft.springdb.lab2.dao.CountryDao;
import com.luxoft.springdb.lab2.model.Country;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CountryJpaDaoImpl extends HibernateDaoSupport implements CountryDao {

	@Override
	@Transactional()
	public void save(Country country) {
		getHibernateTemplate().save(country);
	}

	@Override
	public List<Country> getAllCountries() {
		return getHibernateTemplate().loadAll(Country.class);
	}

	@Override
	public Country getCountryByName(String name) {
		//return getHibernateTemplate().l(Country.class, name);
		return null;
	}
}
