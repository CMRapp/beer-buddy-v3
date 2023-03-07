package com.cmrwebstudio.beerv3.service;

import org.springframework.stereotype.Service;

import com.cmrwebstudio.beerv3.entity.ReviewRequest;
import com.cmrwebstudio.beerv3.entity.Review;

@Service
public interface ReviewRequestService {

	Review createReview(ReviewRequest reviewRequest);

}
