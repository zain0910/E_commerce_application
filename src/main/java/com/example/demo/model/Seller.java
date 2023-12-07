package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sellerId;
	private String sellerName;
	private String managerName;
	private String contactNumber;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

	@OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();

//	public Restaurant(Integer restaurantId, String restaurantName, String managerName, String contactNumber,
//			Address address, List<Item> itemList) {
//		super();
//		this.restaurantId = restaurantId;
//		this.restaurantName = restaurantName;
//		this.managerName = managerName;
//		this.contactNumber = contactNumber;
//		this.address = address;
//		this.itemList = itemList;
//	}
//
//	public Restaurant() {
//		super();
//	}
//
	// public Integer getSellerId() {
	// 	return sellerId;
	// }

	// public void setRestaurantId(Integer restaurantId) {
	// 	this.restaurantId = restaurantId;
	// }
//
//	public String getRestaurantName() {
//		return restaurantName;
//	}
//
//	public void setRestaurantName(String restaurantName) {
//		this.restaurantName = restaurantName;
//	}
//
//	public String getManagerName() {
//		return managerName;
//	}
//
//	public void setManagerName(String managerName) {
//		this.managerName = managerName;
//	}
//
//	public String getContactNumber() {
//		return contactNumber;
//	}
//
//	public void setContactNumber(String contactNumber) {
//		this.contactNumber = contactNumber;
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
//	public List<Item> getItemList() {
//		return itemList;
//	}
//
//	public void setItemList(List<Item> itemList) {
//		this.itemList = itemList;
//	}
//
//	@Override
//	public String toString() {
//		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
//				+ managerName + ", contactNumber=" + contactNumber + ", address=" + address + ", itemList=" + itemList
//				+ "]";
//	}

}
