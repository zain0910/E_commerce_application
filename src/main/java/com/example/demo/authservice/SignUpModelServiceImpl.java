package com.example.demo.authservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.SignUpModel;
import com.example.demo.authrepository.SignUpModelRepository;


@Service
public class SignUpModelServiceImpl implements SignUpModelService {


	@Autowired
	private SignUpModelRepository signUpModelRepository;
	
	@Autowired
	private UserSessionService userSessionService;
	
	
	
	
	@Override
	public SignUpModel newSignUp(SignUpModel signUp) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUpModelRepository.findByUserName(signUp.getUserName());
		if(opt.isPresent())
		{
			throw new AuthorizationException("User Already Exists..!!");
		}
		
		return signUpModelRepository.save(signUp);
	}

	
	@Override
	public SignUpModel updateSignUp(SignUpModel signUp, String key) throws AuthorizationException {
		
		SignUpModel signUpDetails = userSessionService.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new AuthorizationException("User not LoggedIn...!! Try To Login first..");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpModelRepository.save(signUp);
			return signUp;
			}
		else
			throw new AuthorizationException("UserId not found..!!");
	}

}
