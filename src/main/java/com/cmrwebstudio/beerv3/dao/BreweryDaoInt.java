package com.cmrwebstudio.beerv3.dao;

import java.util.List;
import java.util.Optional;

import com.cmrwebstudio.beerv3.entity.Breweries;

/**
 * The BreweryDaoInt interface performs all of the CRUD functions on Brewery objects.
 * @author cmrapp
 *
 */
public interface BreweryDaoInt {

	//fetch a brewery by brewery id
	List<Breweries> fetchBrewery(int breweryPk);
	
	//TODO add a new brewery
	Optional <Breweries> addBrewery(String breweryName, String country, String website);
	
	//TODO update brewery information	
	Optional<Breweries> updateBrewery(int breweryId, String breweryName, String country, String website);
	
	//TODO delete a brewery
	Optional<Breweries> deleteBrewery(int breweryId);
}
