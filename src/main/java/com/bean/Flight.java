package com.bean;

import java.sql.Date;
import java.sql.Time;

public class Flight {
	
	private int flight_number ;
	private Time arrival_time;
	private Date arrival_date;
	private Time departure_time;
	private Date departure_date;

	private int airplane_id ;
	private String departure_city;
	private String arrival_city;

	public Flight() {
		
	}

	public Flight(int flight_number, Time arrival_time, Date arrival_date, Time departure_time,Date departure_date, int airplane_id, String departure_city, String arrival_city) {
		super();
		this.flight_number = flight_number;
		this.arrival_time = arrival_time;
		this.arrival_date = arrival_date;
		this.departure_time = departure_time;
		this.departure_date = departure_date;
		this.airplane_id = airplane_id;
		this.departure_city = departure_city;
		this.arrival_city = arrival_city;
	}

	@Override
	public String toString() {
		return "{flight_number:" + flight_number + ", arrival_time:" + arrival_time + ", arrival_date:"
				+ arrival_date + ", departure_time:" + departure_time + ", departure_date:" + departure_date
				+ ", airplane_id:" + airplane_id + ", departure_city:" + departure_city + ", arrival_city:"
				+ arrival_city + "}";
	}

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + airplane_id;
		result = prime * result + ((arrival_city == null) ? 0 : arrival_city.hashCode());
		result = prime * result + ((arrival_date == null) ? 0 : arrival_date.hashCode());
		result = prime * result + ((arrival_time == null) ? 0 : arrival_time.hashCode());
		result = prime * result + ((departure_city == null) ? 0 : departure_city.hashCode());
		result = prime * result + ((departure_date == null) ? 0 : departure_date.hashCode());
		result = prime * result + ((departure_time == null) ? 0 : departure_time.hashCode());
		result = prime * result + flight_number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (airplane_id != other.airplane_id)
			return false;
		if (arrival_city == null) {
			if (other.arrival_city != null)
				return false;
		} else if (!arrival_city.equals(other.arrival_city))
			return false;
		if (arrival_date == null) {
			if (other.arrival_date != null)
				return false;
		} else if (!arrival_date.equals(other.arrival_date))
			return false;
		if (arrival_time == null) {
			if (other.arrival_time != null)
				return false;
		} else if (!arrival_time.equals(other.arrival_time))
			return false;
		if (departure_city == null) {
			if (other.departure_city != null)
				return false;
		} else if (!departure_city.equals(other.departure_city))
			return false;
		if (departure_date == null) {
			if (other.departure_date != null)
				return false;
		} else if (!departure_date.equals(other.departure_date))
			return false;
		if (departure_time == null) {
			if (other.departure_time != null)
				return false;
		} else if (!departure_time.equals(other.departure_time))
			return false;
		if (flight_number != other.flight_number)
			return false;
		return true;
	}

	

}
