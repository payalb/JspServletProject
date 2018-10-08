package com.bean;

public class Seat {
	private int flight_number ;
	private int economy_seat;
	private int first_seat;
	private int business_seat;
	public Seat(int flight_number, int economy_seat, int first_seat, int business_seat) {
		super();
		this.flight_number = flight_number;
		this.economy_seat = economy_seat;
		this.first_seat = first_seat;
		this.business_seat = business_seat;
	}
	public int getFlight_number() {
		return flight_number;
	}
	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}
	public int getEconomy_seat() {
		return economy_seat;
	}
	public void setEconomy_seat(int economy_seat) {
		this.economy_seat = economy_seat;
	}
	public int getFirst_seat() {
		return first_seat;
	}
	public void setFirst_seat(int first_seat) {
		this.first_seat = first_seat;
	}
	public int getBusiness_seat() {
		return business_seat;
	}
	public void setBusiness_seat(int business_seat) {
		this.business_seat = business_seat;
	}
	@Override
	public String toString() {
		return "['flight_number':'" + flight_number + "', 'economy_seat':'" + economy_seat + "', 'first_seat':'" + first_seat
				+ "', 'business_seat':'" + business_seat + "']";
	}
	
	
}
