package com.cmrwebstudio.beerv3.dao;

import java.util.List;

import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.Breweries;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;
import com.cmrwebstudio.beerv3.entity.Review;

/** The BeerBuddyDao interface calls the methods of the controllers.
 *  
 *  
 *  @author cmrap *
 */
public interface BeerBuddyDao {

	/**
	 * 
	 * @param category
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category);

	List<Breweries> fetchBrewery(int breweryPk);
	
	List<CatDescription> fetchDescription(Category category);

	List<Beer> fetchBeerDetails(int beerId);

	List<Review> fetchReviews(int beerId);


	

}
