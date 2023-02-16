package com.lcwd.rating.repositry;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.entity.Rating;

public interface RatingRepositry extends MongoRepository<Rating, String> {
	
	List<Rating> getRatingByUserId(String userId);
	List<Rating> getRatingByHotelId(String hotelId);

}
