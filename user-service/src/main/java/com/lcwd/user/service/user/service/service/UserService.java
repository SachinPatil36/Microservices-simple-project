package com.lcwd.user.service.user.service.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.lcwd.user.service.user.service.entity.User;


public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	

}
