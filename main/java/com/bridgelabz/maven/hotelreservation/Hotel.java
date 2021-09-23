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
    private double weekendRateRegular;
    
    public Hotel(String hotelName, Double weekdayRateRegular,Double weekendRateRegular) {
    	this.hotelName = hotelName;
    	this.weekdayRateRegular = weekdayRateRegular;
    	this.weekendRateRegular = weekendRateRegular;
    }

	public double getWeekendRateRegular() {
		return weekendRateRegular;
	}

	public void setWeekendRateRegular(double weekendRateRegular) {
		this.weekendRateRegular = weekendRateRegular;
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
