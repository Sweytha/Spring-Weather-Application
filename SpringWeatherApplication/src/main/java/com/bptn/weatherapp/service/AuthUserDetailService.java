package com.bptn.weatherapp.service;

import javax.transaction.Transactional;


import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.request.SignupRequest;

public interface AuthUserDetailService {

	 User login(String username, String userPassword) throws Exception;
	    
	 @Transactional
	 User signup(SignupRequest signupRequest) throws Exception;


}