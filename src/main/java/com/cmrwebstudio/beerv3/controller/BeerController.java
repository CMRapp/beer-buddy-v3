package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.Category;

/** The BeerController interface implements all methods called relating to the Beer Class.
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrapp *
 */

@RequestMapping("/beers")
public class BeerController implements BeerControllerInt {

	@Override
	public List<Beer> fetchBeers(Category category) {
		return null;
	}

	@Override
	public List<Beer> fetchBeerDetails(int beerId) {
		return null;
	}

	@Override
	public List<CatDescription> fetchDescription(Category category) {
		return null;
	}


}
