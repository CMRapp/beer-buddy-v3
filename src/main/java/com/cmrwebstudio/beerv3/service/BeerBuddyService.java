package com.cmrwebstudio.beerv3.service;

import java.util.List;

import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.Breweries;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;
import com.cmrwebstudio.beerv3.entity.Review;

public interface BeerBuddyService {

	/**
	 * 
	 * @param category
	 * @param flavor
	 * @return
	 */
	
	List<Breweries> fetchBrewery(int brewery);

	List<Beer> fetchBeers(Category category);

	List<CatDescription> fetchDescription(Category category);

	List<Beer> fetchBeerDetails(int beerId);

	List<Review> fetchReviews(int beerId);
}
