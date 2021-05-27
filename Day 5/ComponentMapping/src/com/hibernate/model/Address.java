package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	@Column(name="street",length=20)
	private String street;	
	
	@Column(name="city",length=20)
	private String city;
	
	@Column(name="country",length=20)
	private String country;
	
	@Column
	private int zip;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String street, String city, String country, int zip) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", country="
				+ country + ", zip=" + zip + "]";
	}
	
	
	
	
}
