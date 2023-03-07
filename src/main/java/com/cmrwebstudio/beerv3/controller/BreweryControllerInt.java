package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beerv3.entity.Breweries;

public interface BreweryControllerInt {

	//list brewery by id
	@RequestMapping("/breweries")
	
	//list breweries by brewery ID
	@GetMapping("/by_id")
	@ResponseStatus(code = HttpStatus.OK)
	List<Breweries> fetchBrewery(
			@RequestParam(required = false)	int brewery);
			
}
