package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import com.cmrwebstudio.beerv3.entity.Breweries;

/** The BreweryController interface implements all methods called relating to the Breweries Class.
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrapp *
 */

@RequestMapping("/breweries")
public class BreweryController implements BreweryControllerInt {
	
	@Override
	public List<Breweries> fetchBrewery(int brewery) {
		return null;
	}
}
