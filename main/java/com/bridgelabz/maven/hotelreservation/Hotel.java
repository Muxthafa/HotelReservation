package com.bridgelabz.maven.hotelreservation;

import java.util.Date;

/**
 * class to create hotels
 * @author Mohammad Musthafa
 */
public class Hotel 
{
    private String hotelName;
    private double weekdayRateRegular;
    private double weekendRateRegular;
    private double weekendRateReward;
    private double weekdayRateReward;
    private int rating;
    
    public Hotel(String hotelName, Double weekdayRateRegular,Double weekendRateRegular,int rating,double weekdayRateReward,double weekendRateReward) {
    	this.hotelName = hotelName;
    	this.weekdayRateRegular = weekdayRateRegular;
    	this.weekendRateRegular = weekendRateRegular;
    	this.weekendRateReward = weekendRateReward;
    	this.weekdayRateReward= weekdayRateReward;
    	this.rating = rating;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getWeekendRateReward() {
		return weekendRateReward;
	}

	public void setWeekendRateReward(double weekendRateReward) {
		this.weekendRateReward = weekendRateReward;
	}

	public double getWeekdayRateReward() {
		return weekdayRateReward;
	}

	public void setWeekdayRateReward(double weekdayRateReward) {
		this.weekdayRateReward = weekdayRateReward;
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
		return "Hotel [hotelName=" + hotelName + ", weekdayRateRegular=" + weekdayRateRegular + ", weekendRateRegular="
				+ weekendRateRegular + ", weekendRateReward=" + weekendRateReward + ", weekdayRateReward="
				+ weekdayRateReward + ", rating=" + rating + "]";
	}

}
