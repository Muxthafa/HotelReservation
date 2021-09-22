package com.bridgelabz.maven.hotelreservation;

import java.util.Date;

/**
 * class to create hotels
 * @author mohammad.musthafa_ym
 *
 */
public class Hotel 
{
    private String hotelName;
    private double weekdayRateRegular;
    
    public Hotel(String hotelName, Double weekdayRateRegular) {
    	this.hotelName = hotelName;
    	this.weekdayRateRegular = weekdayRateRegular;
    }

	public String getName() {
		return hotelName;
	}

	public void setName(String name) {
		this.hotelName = name;
	}

	public Double getRates() {
		return weekdayRateRegular;
	}

	public void setRates(Double rates) {
		this.weekdayRateRegular = rates;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekdayRateRegular=" + weekdayRateRegular+"]";
	}

	
    
}
