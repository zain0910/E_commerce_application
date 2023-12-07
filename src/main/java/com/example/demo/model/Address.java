package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String area;
	private String city;
	private String state;
	private String country;
	private String pincode;

//	public Address(Integer addressId, String area, String city, String state, String country, String pincode) {
//		super();
//		this.addressId = addressId;
//		this.area = area;
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.pincode = pincode;
//	}
//
//	public Address() {
//		super();
//	}
//
//	public Integer getAddressId() {
//		return addressId;
//	}
//
//	public void setAddressId(Integer addressId) {
//		this.addressId = addressId;
//	}
//
//	public String getArea() {
//		return area;
//	}
//
//	public void setArea(String area) {
//		this.area = area;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public String getPincode() {
//		return pincode;
//	}
//
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//
//	@Override
//	public String toString() {
//		return "Address [addressId=" + addressId + ", area=" + area + ", city=" + city + ", state=" + state
//				+ ", country=" + country + ", pincode=" + pincode + "]";
//	}

}
