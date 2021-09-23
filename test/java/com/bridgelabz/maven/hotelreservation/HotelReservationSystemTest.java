package com.bridgelabz.maven.hotelreservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


/**
 * Unit test for HotelReservationSystem
 */

public class HotelReservationSystemTest 
{
	HotelReservationSystem reservation = new HotelReservationSystem();
	
    @Before
	public void CheckIfHotelIsAdded() {
		reservation.addhotels("Bridgewood", 150, 50,4,110,50);
		reservation.addhotels("Lakewood", 110, 90,3,80,80);
		reservation.addhotels("Ridgewood", 220, 150,5,100,40);
		Assert.assertEquals("Bridgewood", reservation.checkHotel("Bridgewood"));
		Assert.assertEquals("Lakewood", reservation.checkHotel("Lakewood"));
		Assert.assertEquals("Ridgewood", reservation.checkHotel("Ridgewood"));
	}
    
    
    @Test
    public void checkCheapestHotelForGivenRange() {
    	String result = reservation.cheapestHotel(reservation.getDate("11-09-2020"),reservation.getDate("12-09-2020"));
		assertEquals("Bridgewood",result);
    }
    
    @Test
    public void checkBestRatedHotel() {
    	String result = reservation.bestRatedHotel();
		assertEquals("Ridgewood",result);
    }

}
