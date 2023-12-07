package com.example.demo.authservice;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.SignUpModel;
import com.example.demo.authmodels.UserSession;

public interface UserSessionService {
	
	public UserSession getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
	

}
