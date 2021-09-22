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
    public void CheckIfHotelIsAdded()
    {
    	reservation.addhotels("Bridgewood", 345.56,313.26);
    	reservation.addhotels("Lakewood", 145.56,123.11);
    	reservation.addhotels("Ridgewood", 545.56,456.13);
    	Assert.assertEquals("Bridgewood", reservation.checkHotel("Bridgewood"));
    	Assert.assertEquals("Lakewood", reservation.checkHotel("Lakewood"));
    	Assert.assertEquals("Ridgewood", reservation.checkHotel("Ridgewood"));
		
    }
    
    @Test
    public void checkCheapestHotelForGivnRange() {
    	String result = reservation.cheapestHotel(reservation.getDate("9-09-2020"),reservation.getDate("12-09-2020"));
		assertEquals("Lakewood",result);
    }
    
    @Test
    public void checkCheapestHotelForGivnRange2() {
    	String result = reservation.cheapestHotel(reservation.getDate("9-09-2020"),reservation.getDate("12-09-2020"));
		assertEquals("Lakewood",result);
    }
}
