package com.cmrwebstudio.beerv3.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beerv3.dao.BeerBuddyDao;
import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.Breweries;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;
import com.cmrwebstudio.beerv3.entity.Review;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBeerBuddyService implements BeerBuddyService {

	
	@Autowired
	private BeerBuddyDao beerBuddyDao;
	
	@Transactional(readOnly = true)
	@Override
	
	//Returns list of beers by category
	public List<Beer> fetchBeers(Category category) {
		log.info("The fetchBeers method was called with category = {}", category);
		
		List<Beer> beers = beerBuddyDao.fetchBeers(category);
		
		if(beers.isEmpty() ) {
			String msg = String.format("No beers found with category = %s", category);
			throw new NoSuchElementException(msg);
		}
		Collections.sort(beers);
		return beers;
	}

	@Transactional(readOnly = true)
	@Override
	
	// Returns brewery by Id
	public List<Breweries> fetchBrewery(int brewery) {
		log.info("The fetchBrewery method was called with id = {}", brewery);
		
		List<Breweries> breweries = beerBuddyDao.fetchBrewery(brewery);
		System.out.println(brewery);
		if(breweries.isEmpty() ) {
			String msg = String.format("No breweries found with ID = %s", brewery);
			throw new NoSuchElementException(msg);
		}
		
		return breweries;
	}

	@Transactional(readOnly = true)
	@Override
	// Returns Category description by ID
	public List<CatDescription> fetchDescription(Category category) {
		log.info("The fetchDescription method was called with desc = {}", category);
		
		List<CatDescription> description = beerBuddyDao.fetchDescription(category);
		
		if(description.isEmpty() ) {
			String msg = String.format("No descriptions found found with category = %s", category);
			throw new NoSuchElementException(msg);
		}
		
		return description;
	}

	@Transactional(readOnly = true)
	@Override
	// Returns details of a beer by ID
	public List<Beer> fetchBeerDetails(int beerId) {
		log.info("The fetchDescription method was called with desc = {}", beerId);
		
		List<Beer> details = beerBuddyDao.fetchBeerDetails(beerId);
		
		if(details.isEmpty() ) {
			String msg = String.format("No beers found  with ID = %s", beerId);
			throw new NoSuchElementException(msg);
		}
		
		return details;
	}

	@Transactional(readOnly = true)
	@Override
	// Returns reviews of a beer provided a beer ID
	public List<Review> fetchReviews(int beerId) {
			log.info("The fetchReviews method was called with beerID = {}", beerId);
			
			List<Review> review = beerBuddyDao.fetchReviews(beerId);
			
			if(review.isEmpty() ) {
				String msg = String.format("No reviews found with beerId = %s", beerId);
				throw new NoSuchElementException(msg);
			}
			return review;
	}

}
