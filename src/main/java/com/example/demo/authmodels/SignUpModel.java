package com.example.demo.authmodels;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users")
@Entity
public class SignUpModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Pattern(regexp = "[a-zA-Z]{5,15}", message = "Username must be of length 5-15 alphabetical characters")
	private String userName;

	@Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "Password must be of length 5-20 alphanumeric characters")
	private String password;

	@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be of 10 digits")
	private String mobileNo;

	@Email
	private String email;

//	public SignUpModel(Integer userId,
//			@Pattern(regexp = "[a-zA-Z]{5,15}", message = "Username must be of length 5-15 alphabetical characters") String userName,
//			@Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "Password must be of length 5-20 alphanumeric characters") String password,
//			@Pattern(regexp = "[0-9]{10}", message = "Mobile number must be of 10 digits") String mobileNo,
//			@Email String email) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.password = password;
//		this.mobileNo = mobileNo;
//		this.email = email;
//	}
//
//	public SignUpModel() {
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
//	public String getMobileNo() {
//		return mobileNo;
//	}
//
//	public void setMobileNo(String mobileNo) {
//		this.mobileNo = mobileNo;
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
//	@Override
//	public String toString() {
//		return "SignUpModel [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNo="
//				+ mobileNo + ", email=" + email + "]";
//	}

}
