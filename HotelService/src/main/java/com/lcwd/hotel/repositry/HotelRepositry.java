package com.lcwd.hotel.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.entity.Hotel;

public interface HotelRepositry  extends JpaRepository<Hotel, String>{

}
