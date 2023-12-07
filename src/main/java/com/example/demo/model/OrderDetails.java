package com.example.demo.model;

import java.time.LocalDateTime;

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
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDateTime orderDate;
	private String orderStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Bill bill;

//	public OrderDetails(Integer orderId, LocalDateTime orderDate, String orderStatus, FoodCart cart, Bill bill) {
//		super();
//		this.orderId = orderId;
//		this.orderDate = orderDate;
//		this.orderStatus = orderStatus;
//		this.cart = cart;
//		this.bill = bill;
//	}
//
//	public OrderDetails() {
//		super();
//	}
//
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//
//	public LocalDateTime getOrderDate() {
//		return orderDate;
//	}
//
//	public void setOrderDate(LocalDateTime orderDate) {
//		this.orderDate = orderDate;
//	}
//
//	public String getOrderStatus() {
//		return orderStatus;
//	}
//
//	public void setOrderStatus(String orderStatus) {
//		this.orderStatus = orderStatus;
//	}
//
//	public FoodCart getCart() {
//		return cart;
//	}
//
//	public void setCart(FoodCart cart) {
//		this.cart = cart;
//	}
//
//	public Bill getBill() {
//		return bill;
//	}
//
//	public void setBill(Bill bill) {
//		this.bill = bill;
//	}
//
//	@Override
//	public String toString() {
//		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
//				+ ", cart=" + cart + ", bill=" + bill + "]";
//	}

}
