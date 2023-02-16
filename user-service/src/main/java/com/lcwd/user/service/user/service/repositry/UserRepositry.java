package com.lcwd.user.service.user.service.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcwd.user.service.user.service.entity.User;

@Repository
public interface UserRepositry extends JpaRepository<User, String>{
	
	
	
	

}
