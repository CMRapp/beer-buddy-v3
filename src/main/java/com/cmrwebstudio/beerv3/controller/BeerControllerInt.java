package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.cmrwebstudio.beerv3.entity.Beer;
import com.cmrwebstudio.beerv3.entity.CatDescription;
import com.cmrwebstudio.beerv3.entity.Category;

@RequestMapping("/beers")
public interface BeerControllerInt {

	//list all beers by category
	@GetMapping("/by_category")
	@ResponseStatus(code = HttpStatus.OK)
	List<Beer> fetchBeers(
			@RequestParam(required = true)	Category category);
	
	//list details of a beer by beerID
	@GetMapping("/beer_details")
	@ResponseStatus(code = HttpStatus.OK)
	List<Beer> fetchBeerDetails(
			@RequestParam(required = false)	int beerId);
	
	//list beer category descriptions by Category name
	@GetMapping("/category_descritpion")
	@ResponseStatus(code = HttpStatus.OK)
	List<CatDescription> fetchDescription(
			@RequestParam(required = false)	Category category);
}