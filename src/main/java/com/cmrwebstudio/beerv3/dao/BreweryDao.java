package com.cmrwebstudio.beerv3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.beerv3.entity.Breweries;
import com.cmrwebstudio.beerv3.entity.Distributor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BreweryDao implements BreweryDaoInt {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//return brewery information given a brewery id
		@Override
		public List<Breweries> fetchBrewery(int brewery_pk) {
			log.debug("DAO: breweryId = {}", brewery_pk);
			String sql;
			
			if(brewery_pk <= 0) {
				// @formatter: off
				sql = ""
					+ "SELECT * "
					+ "FROM brewery "
					+ "WHERE brewery_pk = brewery_pk"; 	//removing : causes all to display
				// @formatter: on
			
			} else {
				// @formatter: off
				sql = ""
					+ "SELECT * "
					+ "FROM brewery "
					+ "WHERE brewery_pk = :brewery_pk";
				// @formatter: on
			}
			
			
			Map<String, Object> params = new HashMap<>();
			params.put("brewery_pk", brewery_pk);
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Breweries mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter: off
				return Breweries.builder()
					.breweryId(rs.getInt("brewery_pk"))
					.breweryName(rs.getString("name"))
					.country(rs.getString("country"))
					.website(rs.getString("website"))
					.build();
				// @formatter:on
				}});
		}

	//add new brewery	
	@Override
	public Optional<Breweries> addBrewery(String breweryName, String country, String website) {
		String sql = ""
				+ "INSERT INTO brewery (breweryName, country, website) "
				+ "VALUES (:breweryName, :country, :website)";
		Map<String, Object> params = new HashMap<>();
		params.put("name", breweryName);
		params.put("country", country);
		params.put("website", website);
		jdbcTemplate.update(sql,  params);
		
		return Optional.ofNullable(Breweries
				.builder()
				.breweryName(breweryName)
				.country(country)
				.website(website)
				.build()
				);
	}
	
	// update an existing distributor given a brewery id
	public Optional<Breweries> updateBrewery(int breweryId, String breweryName, String country, String website){
		String sql = ""
				+ "UPDATE brewery "
				+ "SET name = :breweryName, country = :country, website = :website "
				+ "WHERE brewery_pk = :breweryId";
		Map<String, Object> params = new HashMap<>();
		params.put("name", breweryName);
		params.put("country", country);
		params.put("website", website);
		jdbcTemplate.update(sql,  params);
		
		return Optional.ofNullable(Breweries
				.builder()
				.breweryName(breweryName)
				.country(country)
				.website(website)
				.build()
				);
	}

	//delete a brewery given a brewery id
	@Override
	public Optional<Breweries> deleteBrewery(int breweryId) {
		String sql = ""
				+ "DELETE FROM brewery "
				+ "WHERE brewery_pk = :breweryId";
		
		Map<String, Object> params = new HashMap<>();
		params.put("brewery_pk", breweryId);
		jdbcTemplate.update(sql, params);
		
		return Optional.ofNullable(Breweries
				.builder()
				.breweryId(breweryId)
				.build());
	}
}
