package com.lcwd.rating.service;

import java.util.List;

import com.lcwd.rating.entity.Rating;

public interface RatingService {
	
	
	//create 
	Rating create(Rating rating);
	
	//get all rating 
	List<Rating>  getRatings();
	
	//get all by userId
	List<Rating> getRatingByUserId(String UserId);
	
	//get all by hotel 
	List<Rating> getRatingByHotelId(String  hotelId);
	
	

}
