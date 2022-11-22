package com.bptn.weatherapp.service.impl;


import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.AuthUserRepository;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.repository.UserRepository;
import com.bptn.weatherapp.request.SignupRequest;
import com.bptn.weatherapp.service.AuthUserDetailService;
import com.bptn.weatherapp.service.UserService;

import java.time.Instant;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthUserDetailServiceImpl implements AuthUserDetailService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private CityRepository cityRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Override
    public User login(String username, String userPassword) throws Exception {
        if (username == null || userPassword == null){
            throw new Exception("UserName or Password can't be null");
        }
        User user = userService.findUserByUsername(username);
        if (user == null) {
            throw new Exception("User doesn't exist");
        }
        AuthUserDetail authUserDetail =
                authUserRepository.findAuthUserDetailByUserIDAndUserPassword(user, userPassword);
        if (authUserDetail == null){
            throw new Exception("Invalid credentials");
        }
        return user;
    }
    @Override
    public User signup(SignupRequest signupRequest) {
   	 City city = cityRepository.findCityByName(signupRequest.getCityName());
        if (city == null){
            city = new City();
            city.setCountry(signupRequest.getCountry());
            city.setName(signupRequest.getCityName());
        }
        User user = null;
        boolean userExists = true;
        try {
            user =  userService.findUserByUsername(signupRequest.getUsername());
           
        } catch (Exception e) {
            LOGGER.info("User doesn't exist. Expected Error");
            userExists = false;
            
        }
        
        if(userExists == false) {
       	 
       	 user = new User();
            user.setUsername(signupRequest.getUsername());
            user.setAddress(signupRequest.getAddress());
            user.setEmailID(signupRequest.getEmailId());
            user.setCreatedOn(Instant.now());
            user.setFirstName(signupRequest.getFirstName());
            user.setLastName(signupRequest.getLastName());
            user.setAdmin(signupRequest.isAdmin());
            user.setPhone(signupRequest.getPhone() + "");
            
            AuthUserDetail authUserDetail = new AuthUserDetail();
            authUserDetail.setUsername(signupRequest.getUsername());
            authUserDetail.setUserPassword(signupRequest.getPassword());
            authUserDetail.setSecurityAnswer1(signupRequest.getSecurityAnswer1());
            authUserDetail.setSecurityAnswer2(signupRequest.getSecurityAnswer2());
            authUserDetail.setSecurityAnswer3(signupRequest.getSecurityAnswer3());
            authUserDetail.setSecurityQuestion1(signupRequest.getSecurityQuestion1());
            authUserDetail.setSecurityQuestion2(signupRequest.getSecurityQuestion2());
            authUserDetail.setSecurityQuestion3(signupRequest.getSecurityQuestion3());
            city = cityRepository.save(city);
            user.setCityID(city);
            try {
           	 LOGGER.info(user.getUsername());
           	 user = userService.createUser(user);
           	 authUserDetail.setUserID(user);
           	 authUserRepository.save(authUserDetail);
            } catch (Exception e) {
           	 LOGGER.error("Create user error");
           	 LOGGER.error(e.toString());
            }
        }
        return user;
   }
   /* @Override
    public User signup(AuthUserDetail userDetail) {
    	//cityRepository.save(userDetail.getUserID().getCityID()); //create city object in city table
    	//userRepository.save(userDetail.getUserID());// create user object in user table
        authUserRepository.save(userDetail); // create AuthUser object
        
       
        
        return userDetail.getUserID();*/
    }


