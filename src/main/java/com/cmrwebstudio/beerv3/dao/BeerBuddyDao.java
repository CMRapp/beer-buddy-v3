package com.cmrwebstudio.beerv3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;
import com.cmrwebstudio.beerv3.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BeerBuddyDao implements BeerBuddyDaoInt {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	//return a list of beers given the beer category
	@Override
	public List<Beer> fetchBeers(Category category) {
		log.debug("DAO: category = {} ", category);
		// @formatter: off
				
		String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE category = :category";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("category", category.toString());
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beerId(rs.getInt("beer_pk"))
				.breweryId(rs.getInt("brewery_id"))
				.beerName(rs.getString("beer_name"))
				.category(Category.valueOf(rs.getString("category")))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getInt("ibu"))
				.beerDesc(rs.getString("description"))
				.build();
			// @formatter:on
			}});
	}
	
	//return a description of a beer category given the category name
	@Override
	public List<CatDescription> fetchDescription(Category category) {
			log.debug("fetchDescription: category = {} ", category);
			System.out.println(category);
			// @formatter: off
			String cat = "'"+category.toString()+"'";
			String sql = ""
				+ "SELECT * "
				+ "FROM category "
				+ "WHERE name = " + cat;
			// @formatter: on
			
			Map<String, Object> params = new HashMap<>();
			params.put("name", category.toString());
			
			return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public CatDescription mapRow(ResultSet rs, int rowNum) throws SQLException {
				// @formatter: off
				return CatDescription.builder()
					.catId(rs.getInt("category_pk"))
					.catName(rs.getString("name"))
					.catDesc(rs.getString("description"))
					.build();
				// @formatter:on
				}});
	}

	//return details of a beer given the beer id
	@Override
	public List<Beer> fetchBeerDetails(int beer_pk) {
		log.debug("DAO: Beer Id = {} ", beer_pk);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM beers "
			+ "WHERE beer_pk = :beer_pk";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Beer.builder()
				.beerId(rs.getInt("beer_pk"))
				.breweryId(rs.getInt("brewery_id"))
				.beerName(rs.getString("beer_name"))
				.category(Category.valueOf(rs.getString("category")))
				.abv(rs.getDouble("abv"))
				.ibu(rs.getInt("ibu"))
				.beerDesc(rs.getString("description"))
				.build();
			// @formatter:on
			}});
	}

	//return reviews for a beer given the beer id
	@Override
	public List<Review> fetchReviews(int beer_pk) {
		log.debug("DAO: Beer Id = {} ", beer_pk);
		// @formatter: off
			String sql = ""
			+ "SELECT * "
			+ "FROM reviews "
			+ "RIGHT JOIN beer_reviews " 
			+ "ON reviews.beer_pk = beer_reviews.beer_pk "
			+ "WHERE beer_reviews.beer_pk = :beer_pk "
			+ "GROUP BY reviews.review ";
		// @formatter: on
		
				
		Map<String, Object> params = new HashMap<>();
		params.put("beer_pk", beer_pk);
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

		@Override
		public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
			// @formatter: off
			return Review.builder()
				.reviewPk(rs.getInt("review_pk"))
				.beerId(rs.getInt("beer_pk"))
				.beerName(rs.getString("beer_name"))
				.reviewerName(rs.getString("reviewer_name"))
				.rating(rs.getInt("rating"))
				.review(rs.getString("review"))
				.build();
			// @formatter:on
			}});
	}

	
}
