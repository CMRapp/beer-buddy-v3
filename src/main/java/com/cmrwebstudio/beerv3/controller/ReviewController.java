package com.cmrwebstudio.beerv3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import com.cmrwebstudio.beerv3.entity.Review;

/** The ReviewyController interface implements all methods called relating to the Reviews Class.
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrapp *
 */

@RequestMapping("/reviews")
public class ReviewController implements ReviewControllerInt {

	@Override
	public List<Review> fetchReviews(int beerId) {
		return null;
	}
	
}
