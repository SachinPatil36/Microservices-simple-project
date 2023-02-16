package com.lcwd.rating.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.repositry.RatingRepositry;
import com.lcwd.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepositry  ratingRepositry;

	@Override
	public Rating create(Rating rating) {
		
		return ratingRepositry.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		
		return ratingRepositry.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepositry.getRatingByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
	
		return ratingRepositry.getRatingByHotelId(hotelId);
	}

}
