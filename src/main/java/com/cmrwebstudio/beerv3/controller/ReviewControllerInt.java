package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beerv3.entity.Review;

@RequestMapping("/reviews")
public interface ReviewControllerInt {

	//display all reviews of a beer by beer ID
		@GetMapping("/beer_review")
		@ResponseStatus(code = HttpStatus.OK)
		List<Review> fetchReviews(
				@RequestParam(required = false)	int beerId);
	
}
