package com.cmrwebstudio.beerv3.dao;

import java.util.List;

import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;
import com.cmrwebstudio.beerv3.entity.Review;

/** The BeerBuddyDao interface calls the methods of the controllers for all Beer objects.
 *  
 *  
 *  @author cmrap *
 */
public interface BeerBuddyDaoInt {

	/**
	 * 
	 * @param category
	 * @return
	 */
	
	//BEER FUNCTIONS
	List<Beer> fetchBeers(Category category);					//fetch all beers
	
	List<Beer> fetchBeerDetails(int beerId);					//fetch beer details

	List<Review> fetchReviews(int beerId);						//fetch reviews for a beer
	
	//TODO 3/7/23 Delete beer by ID		
	//TODO 3/27/23 Update beer details
	
	
	//MISC FUNCTIONS
	List<CatDescription> fetchDescription(Category category);	//fetch category description


	

}
