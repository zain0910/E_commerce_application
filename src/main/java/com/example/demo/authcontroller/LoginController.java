package com.example.demo.authcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.LogInModel;
import com.example.demo.authservice.LogInModelServiceImpl;

@RestController
public class LoginController {
	
	@Autowired
	private LogInModelServiceImpl logInModelServiceImpl;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody LogInModel loginData) throws AuthorizationException {
		return logInModelServiceImpl.LogIn(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key) throws AuthorizationException
	{
		return logInModelServiceImpl.LogOut(key);
	}
	

}
