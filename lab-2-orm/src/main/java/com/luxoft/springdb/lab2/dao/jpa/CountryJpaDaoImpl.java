package com.luxoft.springdb.lab2.dao.jpa;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.luxoft.springdb.lab2.dao.CountryDao;
import com.luxoft.springdb.lab2.model.Country;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository
public class CountryJpaDaoImpl  implements CountryDao {
	protected EntityManagerFactory entityManagerFactory;

	@PersistenceContext
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	@Transactional()
	public void save(Country country) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(country);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<Country> getAllCountries() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		List<Country> countries = entityManager.createQuery("from Country", Country.class).getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return countries;
	}

	@Override
	public Country getCountryByName(String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Country country = entityManager.createQuery("select c from Country c where c.name like :name", Country.class)
			.getSingleResult();

		entityManager.getTransaction().commit();
		entityManager.close();

		return country;
	}
}
