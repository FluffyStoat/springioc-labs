package com.luxoft.springdb.lab1.dao;

import com.luxoft.springdb.lab1.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class CountryDao {
	private static final String GET_ALL_COUNTRIES_SQL = "select * from country";
	private static final String UPDATE_COUNTRY_NAME_SQL = "update country SET name = ? where code_name = ?";

	public static final String[][] COUNTRY_INIT_DATA = { { "Australia", "AU" },
			{ "Canada", "CA" }, { "France", "FR" }, { "Hong Kong", "HK" },
			{ "Iceland", "IC" }, { "Japan", "JP" }, { "Nepal", "NP" },
			{ "Russian Federation", "RU" }, { "Sweden", "SE" },
			{ "Switzerland", "CH" }, { "United Kingdom", "GB" },
			{ "United States", "US" } };

	private static final RowMapper<Country> COUNTRY_ROW_MAPPER = (resultSet, i) -> {
		Country country = new Country();
		country.setId(resultSet.getInt("id"));
		country.setName(resultSet.getString("name"));
		country.setCodeName(resultSet.getString("code_name"));
		return country;
	};

	private final JdbcOperations jdbcOperations;
	private final NamedParameterJdbcTemplate namedTemplate;

	@Autowired
	public CountryDao(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
		namedTemplate = new NamedParameterJdbcTemplate(jdbcOperations);
	}

	public List<Country> getCountryList() {
		return jdbcOperations.query(GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER);
	}

	public List<Country> getCountryListStartWith(String name) {
		return namedTemplate.query("select * from country where name like :name || '%'",
			new MapSqlParameterSource("name", name),
			COUNTRY_ROW_MAPPER
		);
	}

	public void updateCountryName(String codeName, String newCountryName) {
		jdbcOperations.update(UPDATE_COUNTRY_NAME_SQL, newCountryName, codeName);
	}

	public void loadCountries() {
		jdbcOperations.batchUpdate("insert into country (name, code_name) values (?, ?)",
			new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					ps.setString(1, COUNTRY_INIT_DATA[i][0]);
					ps.setString(2, COUNTRY_INIT_DATA[i][1]);
				}
				@Override
				public int getBatchSize() {
					return COUNTRY_INIT_DATA.length;
				}
			}
		);
	}

	public Country getCountryByCodeName(String codeName) {
		return namedTemplate.query("select * from country where code_name = :code_name",
			new MapSqlParameterSource("code_name", codeName),
			COUNTRY_ROW_MAPPER
		).get(0);
	}
}
