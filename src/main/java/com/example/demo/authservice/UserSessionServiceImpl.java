package com.example.demo.authservice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.SignUpModel;
import com.example.demo.authmodels.UserSession;
import com.example.demo.authrepository.SignUpModelRepository;
import com.example.demo.authrepository.UserSessionRepository;


@Service
public class UserSessionServiceImpl implements UserSessionService {

	@Autowired
	private UserSessionRepository userSessionRepository;
	
	@Autowired
	private SignUpModelRepository signUpModelRepository;
	
	
	
	@Override
	public UserSession getUserSession(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getUserSessionId(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUser = userSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			throw new AuthorizationException("Not Authorized..!!");
		}
		return currentUser.get().getId();
		
	}


	@Override
	public SignUpModel getSignUpDetails(String key) {
		
		Optional<UserSession> currentUser = userSessionRepository.findByUUID(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpModelRepository.findById(SignUpUserId)).get();
	}

}
