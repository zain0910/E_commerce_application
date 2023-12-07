package com.example.demo.authmodels;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
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
public class UserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private Integer userId;
	private String UUID;
	private LocalDateTime timeStamp;

	public UserSession(Integer userId, String uuid, LocalDateTime localDateTime) {
		super();
		this.userId = userId;
		this.UUID = uuid;
		this.timeStamp = localDateTime;
	}
//
//	public UserSession() {
//		super();
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	public String getUUID() {
//		return UUID;
//	}
//
//	public void setUUID(String uUID) {
//		UUID = uUID;
//	}
//
//	public LocalDateTime getTimeStamp() {
//		return timeStamp;
//	}
//
//	public void setTimeStamp(LocalDateTime timeStamp) {
//		this.timeStamp = timeStamp;
//	}
//
//	@Override
//	public String toString() {
//		return "UserSession [id=" + id + ", userId=" + userId + ", UUID=" + UUID + ", timeStamp=" + timeStamp + "]";
//	}

}
