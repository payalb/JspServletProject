package com.bean;

public class Airplane {
	
	private int airplane_id;
	private String producer;
	private int type ;

	public Airplane() {
		
	}

	public Airplane(int airplane_id, String producer, int type) {
		super();
		this.airplane_id = airplane_id;
		this.producer = producer;
		this.type = type;
	}

	public int getAirplane_id() {
		return airplane_id;
	}

	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	

}
