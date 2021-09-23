package com.bridgelabz.maven.hotelreservation;

import java.util.Date;

/**
 * class to create hotels
 * @author mohammad.musthafa_ym
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

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public double getWeekdayRateRegular() {
		return weekdayRateRegular;
	}

	public void setWeekdayRateRegular(double weekdayRateRegular) {
		this.weekdayRateRegular = weekdayRateRegular;
	}

	public double getWeekendRateRegular() {
		return weekendRateRegular;
	}

	public void setWeekendRateRegular(double weekendRateRegular) {
		this.weekendRateRegular = weekendRateRegular;
	}

	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", weekdayRateRegular=" + weekdayRateRegular+"]";
	} 
}
