package com.cmrwebstudio.beerv3.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beerv3.dao.ReviewRequestDao;
import com.cmrwebstudio.beerv3.entity.ReviewRequest;
import com.cmrwebstudio.beerv3.entity.Review;

@Service
public class DefaultReviewRequestService implements ReviewRequestService {

	@Autowired
	private ReviewRequestDao reviewRequestDao;

	@Transactional
	@Override
	// Create a review of a beer
	public Review createReview(ReviewRequest reviewRequest) {
		
		int beerId = getReview(reviewRequest).getBeerId();
		String beerName = getReview(reviewRequest).getBeerName();
		String reviewerName = getReview(reviewRequest).getReviewerName();
		int rating = getReview(reviewRequest).getRating();
		String review = getReview(reviewRequest).getReview();
		System.out.println("DAO: beer name = "+beerName);
		return reviewRequestDao.saveReview(beerId, beerName, reviewerName, rating, review);
	}

	// Returns Reviews of a beer by beer ID
	protected Review getReview(ReviewRequest reviewRequest) {
		return reviewRequestDao.fetchReview(reviewRequest.getBeerId(), reviewRequest.getBeerName())
				.orElseThrow(() -> new NoSuchElementException("Review for beer with ID = "
				+ reviewRequest.getBeerId()+ " was not found."));
	}

}
