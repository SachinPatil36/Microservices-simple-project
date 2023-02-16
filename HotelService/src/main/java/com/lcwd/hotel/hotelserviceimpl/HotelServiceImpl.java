package com.lcwd.hotel.hotelserviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.exception.ResourseNotFoundException;
import com.lcwd.hotel.repositry.HotelRepositry;
import com.lcwd.hotel.service.HotelService;


@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
    private HotelRepositry hotelRepositry;

	@Override
	public Hotel create(Hotel hotel) {
		
		String hotelId=UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		
		return hotelRepositry.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepositry.findAll();
	}

	@Override
	public Hotel get(String hotelId) {
		
		return hotelRepositry.findById(hotelId).orElseThrow(()-> new ResourseNotFoundException("hotel with given id is not found!!"));
	}
	
	

}
