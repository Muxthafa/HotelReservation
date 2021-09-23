package com.bridgelabz.maven.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * class to store different hotels
 * @author mohammad.musthafa_ym
 */

public class HotelReservationSystem {
	private List<Hotel> hotelDetails = new ArrayList<Hotel>();
	
	SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");	// Date format class
	
	/**
	 * @method to add hotel to the list
	 * @param hotelName
	 * @param weekdayRateRegular
	 */
	public void addhotels(String hotelName,double weekdayRateRegular,double weekendRateRegular) {
		hotelDetails.add(new Hotel(hotelName,weekdayRateRegular,weekendRateRegular));
	}
	
	/**
	 * @method to find the cheapest hotel
	 * @param date1(starting date)
	 * @param date2(ending date)
	 * @return
	 */
	public String cheapestHotel(Date date1, Date date2) {
		LocalDate startingDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endingDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int numOfDays = Period.between(startingDate, endingDate).getDays();
		Map<String,Double> hotelPrice = new HashMap<String,Double>();
		
		for(Hotel hotel : hotelDetails) {
			double totalCost = 0;
			for(int i=0;i<numOfDays;i++) {
				totalCost += hotel.getRates();
			}
			hotelPrice.put(hotel.getName(), totalCost);
		}
		double minPrice = Collections.min(hotelPrice.values());
		String hotel = hotelPrice.entrySet()
						.stream()
						.filter(entry -> minPrice == entry.getValue())
						.map(Map.Entry::getKey)
						.findFirst().get();
		return hotel;					
	}
	
	/**
	 * @method to check if hotel is present
	 * @param name
	 * @return
	 */
	public String checkHotel(String name) {
		for(Hotel hotel : hotelDetails) {
			if(hotel.getName().equals(name)) {
				return name;
			}
		}
		return "notFound";
	}
	
	/**
	 * method to convert string to date format
	 * @param date
	 * @return
	 */
	public Date getDate(String date) {
		
    	try {
			return new SimpleDateFormat("dd-MM-yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	return null;
	}
}
