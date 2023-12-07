package com.example.demo.authservice;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.SignUpModel;

public interface SignUpModelService {
	
	public SignUpModel newSignUp(SignUpModel signUp) throws AuthorizationException;;
	
	public SignUpModel updateSignUp(SignUpModel signUp, String key) throws AuthorizationException;;

}
