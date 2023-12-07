package com.example.demo.authservice;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.LogInModel;

public interface LogInModelService {
	
	public String LogIn(LogInModel login) throws AuthorizationException;
	
	public String LogOut(String key) throws AuthorizationException;

}
