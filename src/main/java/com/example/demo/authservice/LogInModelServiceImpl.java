package com.example.demo.authservice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.authexceptions.AuthorizationException;
import com.example.demo.authmodels.LogInModel;
import com.example.demo.authmodels.SignUpModel;
import com.example.demo.authmodels.UserSession;
import com.example.demo.authrepository.LogInModelRepository;
import com.example.demo.authrepository.SignUpModelRepository;
import com.example.demo.authrepository.UserSessionRepository;


@Service
public class LogInModelServiceImpl implements LogInModelService {
	

	@Autowired
	private SignUpModelRepository signUpModelRepository;
	
	@Autowired
	private UserSessionRepository userSessionRepository;
	
	@Autowired
	private UserSessionService userSessionService;
	
	@Autowired
	private LogInModelRepository logInModelRepository;
	
	@Override
	public String LogIn(LogInModel loginData) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUpModelRepository.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			throw new AuthorizationException("Invalid Login UserId");
		}
		
		SignUpModel newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSession> currentUserOptional = userSessionRepository.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new AuthorizationException("User Already LoggedIn with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomString();
			
			UserSession currentUserSession = new UserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionRepository.save(currentUserSession);
			logInModelRepository.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			throw new AuthorizationException("Invalid UserName or Password..");
			
			
		
	}

	@Override
	public String LogOut(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUserOptional = userSessionRepository.findByUUID(key);
		if(!currentUserOptional.isPresent())
		{
			throw new AuthorizationException("Invalid credentials...");
		}
		UserSession currentUserSession = userSessionService.getUserSession(key);
		
		userSessionRepository.delete(currentUserSession);
		
		Optional<LogInModel> loginData = logInModelRepository.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		logInModelRepository.delete(loginData.get());
		
		
		return "Logged Out...";
	
	}

}
