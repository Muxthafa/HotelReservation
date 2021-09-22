package com.bridgelabz.maven.hotelreservation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;


/**
 * Unit test for HotelReservationSystem
 */
public class HotelReservationSystemTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
    	List<Hotel> hotelDetails = new ArrayList<Hotel>();
    	hotelDetails.add(new Hotel("Bridgewood",200.56));
    	hotelDetails.add(new Hotel("Lakewood",600.56));
    	hotelDetails.add(new Hotel("Downtown",500.56));
		HotelReservationSystem reservation = new HotelReservationSystem(hotelDetails);
		String result = reservation.checkHotel("Bridgewood");
		assertEquals("Bridgewood",result);
    }
}
