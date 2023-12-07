package com.example.demo.authcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.SignUpModel;
import com.example.demo.authservice.SignUpModelService;


@RestController
public class SignUpController {
	
	@Autowired
	private SignUpModelService signUpModelService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUpModel> createNewSignUpHandler(@RequestBody SignUpModel newSignUp) throws AuthorizationException {
		
		SignUpModel newSignedUp =signUpModelService.newSignUp(newSignUp);
		return new ResponseEntity<SignUpModel>(newSignedUp,HttpStatus.CREATED);

	}
	
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUpModel> updateSignUpDetailsHandler(@RequestBody SignUpModel signUp, @RequestParam String key) throws AuthorizationException
	{
		SignUpModel newUpdatedSignUp = signUpModelService.updateSignUp(signUp,key);
		
		return new ResponseEntity<SignUpModel>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

}
