package com.example.demo.model;

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
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Integer quantity;
	private Double cost;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;

//	public Item(Integer itemId, String itemName, Integer quantity, Double cost) {
//		super();
//		this.itemId = itemId;
//		this.itemName = itemName;
//		this.quantity = quantity;
//		this.cost = cost;
//	}
//
//	public Item() {
//		super();
//	}
//
//	public Integer getItemId() {
//		return itemId;
//	}
//
//	public void setItemId(Integer itemId) {
//		this.itemId = itemId;
//	}
//
//	public String getItemName() {
//		return itemName;
//	}
//
//	public void setItemName(String itemName) {
//		this.itemName = itemName;
//	}
//
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	public Double getCost() {
//		return cost;
//	}
//
//	public void setCost(Double cost) {
//		this.cost = cost;
//	}
//
//	@Override
//	public String toString() {
//		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", quantity=" + quantity + ", cost=" + cost + "]";
//	}

}
