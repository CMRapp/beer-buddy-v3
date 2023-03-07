package com.cmrwebstudio.beerv3.dao;

import java.util.Optional;


import com.cmrwebstudio.beerv3.entity.Review;

public interface ReviewRequestDaoInt {

	Optional<Review> fetchReview(int beerId, String beerName);

	Review saveReview(int beerId, String beerName, String reviewerName, int rating, String review);

		
}
