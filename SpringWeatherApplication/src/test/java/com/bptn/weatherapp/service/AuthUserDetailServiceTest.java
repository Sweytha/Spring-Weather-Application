package com.bptn.weatherapp.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bptn.weatherapp.AbstractTest;
import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.City;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.repository.AuthUserRepository;
import com.bptn.weatherapp.repository.CityRepository;
import com.bptn.weatherapp.request.SignupRequest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;

public class AuthUserDetailServiceTest extends AbstractTest{
	
	@MockBean
	private AuthUserRepository authUserDetailRepository;

	@MockBean
	private UserService userService;
	
	@MockBean
    private CityRepository cityRepository;
	
	@Autowired
	private AuthUserDetailService authUserDetailService;
	
	@Override
	@Before
	public void setUp() {
	super.setUp();
	}
	
	@Test
	public void loginTest() throws Exception {
	    String username = "test1";
	    String userPassword = "test1";
	    User user = new User();
	    user.setId(104);
	    user.setUsername(username);
	    when(userService.findUserByUsername(username)).thenReturn(user);
	    AuthUserDetail authUserDetail = new AuthUserDetail();
	    authUserDetail.setUserID(user);
	when(authUserDetailRepository.findAuthUserDetailByUserIDAndUserPassword(user, userPassword)).
	thenReturn(authUserDetail);
	    User result = authUserDetailService.login(username, userPassword);
	    assertEquals(user, result);
	}
	
	@Test
	public void signupTest() throws Exception {
	    String signupRequestJson = "{  \"username\": \"test6\",   \"password\": \"test6\", \"firstName\": \"John6\",   \"lastName\": \"Doe6\",   \"emailId\": \"johnny6@gmail.com\", \"address\": \"Toronto\",\"phone\":\"123456\" , \"securityQuestion1\": \"What is mother maiden name?\",\"securityQuestion2\": \"What is your favourite movie?\",\"securityQuestion3\":\"Whats is your favourite sport?\",\"securityAnswer1\":\"M1\",\"securityAnswer2\":\"V1\",\"securityAnswer3\":\"S1\"}";
	    SignupRequest signupRequest = mapFromJson(signupRequestJson, SignupRequest.class);
        AuthUserDetail authUserDetail = new AuthUserDetail();
        authUserDetail.setUserID(new User());
        when(authUserDetailRepository.save(any())).
                thenReturn(authUserDetail);
        City city = new City();
        when(cityRepository.findCityByName(signupRequest.getCityName())).thenReturn(city);
        doThrow(Exception.class).when(userService).findUserByUsername(signupRequest.getUsername());
        when(cityRepository.save(city)).thenReturn(city);
        when(userService.createUser(any())).thenReturn(authUserDetail.getUserID());
        when(authUserDetailRepository.save(any())).thenReturn(authUserDetail);
        User user = authUserDetailService.signup(signupRequest);
        assertEquals(authUserDetail.getUserID(), user);
	}

}
