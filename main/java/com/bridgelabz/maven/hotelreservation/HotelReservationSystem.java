package com.bridgelabz.maven.hotelreservation;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * class to store different hotels
 * 
 * @author mohammad.musthafa_ym
 */

public class HotelReservationSystem {
	private List<Hotel> hotelDetails = new ArrayList<Hotel>();

	SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy"); // Date format class

	/**
	 * @method to add hotel to the list
	 * @param hotelName
	 * @param weekdayRateRegular
	 */
	public void addhotels(String hotelName, double weekdayRateRegular, double weekendRateRegular, int rating, double weekdayRateReward,double weekendRateReward) {
		hotelDetails.add(new Hotel(hotelName, weekdayRateRegular, weekendRateRegular, rating,weekdayRateReward,weekendRateReward));
	}

	/**
	 * @method to find the cheapest hotel for regular as well as reward customers
	 * @param date1(starting date)
	 * @param date2(ending   date)
	 * @return
	 */
	public String cheapestHotel(Date date1, Date date2, String customerType) {
		LocalDate startingDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate endingDate = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int numOfDays = Period.between(startingDate, endingDate).getDays() + 1;

		Map<String, Double> hotelPrice = new HashMap<String, Double>(); // map to store hotel with total price

		List<LocalDate> listOfDates = Stream.iterate(startingDate, date -> date.plusDays(1)) // list stores dates on
																								// range
				.limit(numOfDays).collect(Collectors.toList());

		for (Hotel hotel : hotelDetails) {
			double totalCost = 0;
			for (LocalDate date : listOfDates) {
				if (isWeekend(date)) {
					if(customerType.equals("Regular"))
						totalCost += hotel.getWeekendRateRegular(); // add price of hotel during weekend
					else
						totalCost += hotel.getWeekendRateReward(); // add price of hotel during weekday
				}else {
					if(customerType.equals("Reward"))
						totalCost += hotel.getWeekdayRateReward(); // add price of hotel during weekend
					else
						totalCost += hotel.getWeekdayRateRegular(); // add price of hotel during weekday
					
				}
					
			}
			hotelPrice.put(hotel.getHotelName(), totalCost);
		}

		double minPrice = Collections.min(hotelPrice.values());
		Map<String, Integer> maxRating = new HashMap<String, Integer>(); // map to store equal price hotels

		for (Map.Entry map : hotelPrice.entrySet()) {
			if ((double) map.getValue() == minPrice) {
				maxRating.put((String) map.getKey(), null);
			}
		}

		int max = 0;
		Hotel cheapestHighestRating = null;
		
		
		for (Hotel hotel : hotelDetails) {
			for (Map.Entry map : maxRating.entrySet()) {
				if (hotel.getHotelName().equals(map.getKey())) {
					if (max < hotel.getRating()) {
						max = hotel.getRating();
						cheapestHighestRating = hotel; // the highest rated hotel reference among equal price hotels
					}
				}
			}
		}
		return cheapestHighestRating.getHotelName();
	}
	
	public String bestRatedHotel() {
		int bestRated=0;
		String hotelBestRated = null;
		for (Hotel hotel : hotelDetails) {
			if(hotel.getRating() > bestRated) {
				bestRated=hotel.getRating();
				hotelBestRated=hotel.getHotelName();
			}
		}
		return hotelBestRated;
	}

	/**
	 * @method to check if hotel is present
	 * @param name
	 * @return
	 */
	public String checkHotel(String name) {
		for (Hotel hotel : hotelDetails) {
			if (hotel.getHotelName().equals(name)) {
				return name;
			}
		}
		return "notFound";
	}

	/**
	 * @method to convert string to date format
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

	/**
	 * @method returns true if the day is weekend
	 * @param date
	 * @return
	 */
	public boolean isWeekend(LocalDate date) {
		DayOfWeek day = DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK));
		return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
	}
}
