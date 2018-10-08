package com.bean;

import java.sql.Date;
import java.sql.Time;

public class BHistory {

	private int booking_id;
	private int passanger_id;
	private int flight_number ;
	private Time arrival_time;
	private Date arrival_date;
	private Time departure_time;
	private Date departure_date;

	private int airplane_id ;
	private String departure_city;
	private String arrival_city;
	
	public BHistory(int booking_id, int passanger_id, int flight_number, Time arrival_time, Date arrival_date,
			Time departure_time, Date departure_date, int airplane_id, String departure_city, String arrival_city) {
		super();
		this.booking_id = booking_id;
		this.passanger_id = passanger_id;
		this.flight_number = flight_number;
		this.arrival_time = arrival_time;
		this.arrival_date = arrival_date;
		this.departure_time = departure_time;
		this.departure_date = departure_date;
		this.airplane_id = airplane_id;
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
	}
	
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getPassanger_id() {
		return passanger_id;
	}
	public void setPassanger_id(int passanger_id) {
		this.passanger_id = passanger_id;
	}
	public Time getArrival_time() {
		return arrival_time;
	}
	public void setArrival_time(Time arrival_time) {
		this.arrival_time = arrival_time;
	}
	public Date getArrival_date() {
		return arrival_date;
	}
	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}
	public Time getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(Time departure_time) {
		this.departure_time = departure_time;
	}
	public Date getDeparture_date() {
		return departure_date;
	}
	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}
	public int getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getDeparture_city() {
		return departure_city;
	}
	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}
	public String getArrival_city() {
		return arrival_city;
	}
	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	
}
