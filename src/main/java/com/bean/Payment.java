package com.bean;

import java.time.LocalDateTime;

public class Payment {
	private int payment_id;
	private int booking_id;
	private double payment_amount;
	private LocalDateTime payment_date;

	public Payment() {
		
	}

	public Payment(int payment_id, int booking_id, double payment_amount, LocalDateTime payment_date) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.payment_amount = payment_amount;
		this.payment_date = payment_date;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public double getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(double payment_amount) {
		this.payment_amount = payment_amount;
	}

	public LocalDateTime getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(LocalDateTime payment_date) {
		this.payment_date = payment_date;
	}
	

}
