package com.example.demo.authmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LogInModel {

	@Id
	private Integer userId;

	private String userName;
	private String password;

//	public LogInModel(Integer userId, String userName, String password) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//	}
//
//	public LogInModel() {
//		super();
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
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	@Override
//	public String toString() {
//		return "LogInModel [userId=" + userId + ", userName=" + userName + ", password=" + password + "]";
//	}

}
