package com.bean;

public class Booking {
	
	private int booking_id;
	private int passanger_id;
	private int flight_number;
	private int seat_number ;
	private String baggage ;
	private String cls;
	private String reser_status ;

	public Booking() {
		
	}

	public Booking(int passanger_id, int flight_number, int seat_number, String baggage, String cls,
			String reser_status) {
		super();
		this.passanger_id = passanger_id;
		this.flight_number = flight_number;
		this.seat_number = seat_number;
		this.baggage = baggage;
		this.cls = cls;
		this.reser_status = reser_status;
	}

	public Booking(int booking_id, int passanger_id, int flight_number, int seat_number, String baggage, String cls,
			String reser_status) {
		super();
		this.booking_id = booking_id;
		this.passanger_id = passanger_id;
		this.flight_number = flight_number;
		this.seat_number = seat_number;
		this.baggage = baggage;
		this.cls = cls;
		this.reser_status = reser_status;
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

	public int getFlight_number() {
		return flight_number;
	}

	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getBaggage() {
		return baggage;
	}

	public void setBaggage(String baggage) {
		this.baggage = baggage;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getReser_status() {
		return reser_status;
	}

	public void setReser_status(String reser_status) {
		this.reser_status = reser_status;
	}

	

}
