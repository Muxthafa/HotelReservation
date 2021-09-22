package com.bridgelabz.maven.hotelreservation;

import java.util.ArrayList;
import java.util.List;

/**
 * class to store different hotels
 * @author mohammad.musthafa_ym
 */

public class HotelReservationSystem {
	private List<Hotel> hotelDetails = new ArrayList<Hotel>();
	
	/**
	 * constructor to initialize hotelDetails
	 * @param hotelDetails
	 */
	public HotelReservationSystem(List<Hotel> hotelDetails) {
		this.hotelDetails = hotelDetails;
	}
	
	public String checkHotel(String name) {
		for(Hotel hotel : hotelDetails) {
			if(hotel.getName().equals(name)) {
				return name;
			}
		}
		return "notFound";
	}
	
}
