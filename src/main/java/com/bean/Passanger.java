package com.bean;

public class Passanger {
	
	private int passanger_id;
	private String username;
	private String firstName;
	private String lastName;
	private String ssn;
	private int age;
	private String street;
	private int apartment_number;
	private String city;
	private String state;
	private int zip;
	private String tel_home;
	private String tel_office;
	private String email;


	public Passanger() {
		
	}


	public Passanger(String username, String firstName, String lastName, String ssn, int age, String street,
			int apartment_number, String city, String state, int zip, String tel_home, String tel_office,
			String email) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.age = age;
		this.street = street;
		this.apartment_number = apartment_number;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.tel_home = tel_home;
		this.tel_office = tel_office;
		this.email = email;
	}


	public Passanger(int passanger_id,String username, String firstName, String lastName, String ssn, int age, String street,
			int apartment_number, String city, String state, int zip, String tel_home, String tel_office,
			String email) {
		super();
		this.passanger_id = passanger_id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.age = age;
		this.street = street;
		this.apartment_number = apartment_number;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.tel_home = tel_home;
		this.tel_office = tel_office;
		this.email = email;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getPassanger_id() {
		return passanger_id;
	}


	public void setPassanger_id(int passanger_id) {
		this.passanger_id = passanger_id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getApartment_number() {
		return apartment_number;
	}


	public void setApartment_number(int apartment_number) {
		this.apartment_number = apartment_number;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getTel_home() {
		return tel_home;
	}


	public void setTel_home(String tel_home) {
		this.tel_home = tel_home;
	}


	public String getTel_office() {
		return tel_office;
	}


	public void setTel_office(String tel_office) {
		this.tel_office = tel_office;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	

}
