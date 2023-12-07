package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String fullName;
	private String mobileNumber;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;

//	public Customer(Integer customerId, String fullName, String mobileNumber, String email, Address address,
//			FoodCart foodCart) {
//		super();
//		this.customerId = customerId;
//		this.fullName = fullName;
//		this.mobileNumber = mobileNumber;
//		this.email = email;
//		this.address = address;
//		this.foodCart = foodCart;
//	}
//
//	public Customer() {
//		super();
//	}
//
//	public Integer getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}
//
//	public String getFullName() {
//		return fullName;
//	}
//
//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}
//
//	public String getMobileNumber() {
//		return mobileNumber;
//	}
//
//	public void setMobileNumber(String mobileNumber) {
//		this.mobileNumber = mobileNumber;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public FoodCart getFoodCart() {
//		return foodCart;
//	}
//
//	public void setFoodCart(FoodCart foodCart) {
//		this.foodCart = foodCart;
//	}
//
//	@Override
//	public String toString() {
//		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
//				+ ", email=" + email + ", address=" + address + ", foodCart=" + foodCart + "]";
//	}

}
