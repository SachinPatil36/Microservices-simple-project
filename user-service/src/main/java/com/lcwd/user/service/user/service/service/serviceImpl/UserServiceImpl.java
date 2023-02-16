package com.lcwd.user.service.user.service.service.serviceImpl;


import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.user.service.entity.Hotel;
import com.lcwd.user.service.user.service.entity.Rating;
import com.lcwd.user.service.user.service.entity.User;
import com.lcwd.user.service.user.service.exception.ResourseNotFoundException;
import com.lcwd.user.service.user.service.repositry.UserRepositry;
import com.lcwd.user.service.user.service.service.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	@Override
	public User saveUser(User user) {
		String ramdamUserId=UUID.randomUUID().toString();
		
		user.setUserId(ramdamUserId);
		
		return userRepositry.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepositry.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user=userRepositry.findById(userId).orElseThrow(()->new  ResourseNotFoundException("user with given name is not found"+userId));
		
		
		Rating[]  ratingsOfUser= restTemplate.getForObject("http://RATING-SERVICES/ratings/users/"+user.getUserId(), Rating[].class);
		
		  
	       List<Rating> ratings= Arrays.asList(ratingsOfUser);
		
		  

	        List<Rating> ratingList = ratings.stream().map(rating -> {
			  
			 
			  
			  ResponseEntity<Hotel>  forEntity=restTemplate.getForEntity("http://HOTEL-SERVICES/hotels/"+rating.getHotelId(), Hotel.class);
			  
			  Hotel hotel=forEntity.getBody();
			  
			
			  rating.setHotel(hotel);
			  
			  return rating;
			  
		  }).collect(Collectors.toList());
				  
		
		 user.setRatings(ratingList);
		return user;
	}

}
