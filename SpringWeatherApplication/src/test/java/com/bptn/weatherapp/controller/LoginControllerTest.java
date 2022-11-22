package com.bptn.weatherapp.controller;

import com.bptn.weatherapp.AbstractTest;
import com.bptn.weatherapp.models.User;
import com.bptn.weatherapp.request.LoginRequest;
import com.bptn.weatherapp.request.SignupRequest;
import com.bptn.weatherapp.service.AuthUserDetailService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class LoginControllerTest extends AbstractTest {

    @MockBean
    private AuthUserDetailService authUserDetailService;

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void loginTest() throws Exception {
        String uri = "/login";
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("test1");
        loginRequest.setUsername("test1");
        String requestJson= mapToJson(loginRequest);
        User user = new User();
        user.setId(104);
        when(authUserDetailService.login(Mockito.anyString(), Mockito.anyString()))
                 .thenReturn(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).content(requestJson)
                        .contentType("application/json").
                accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        User response = mapFromJson(mvcResult.getResponse().getContentAsString(), User.class);
        assertEquals(200, status);
        assertEquals(104, (int)response.getId());
    }

    @Test
    public void signupTest() throws Exception {
        String uri = "/signup";
        String signupRequest = "{\"id\": 2,   \"username\": \"test1\",   \"userPassword\": \"test1\",   \"userID\" : {   \"id\": 104,     \"firstName\": \"Ronaldo\",   \"lastName\": \"Christiano\",   \"emailID\": \"ronaldo@123.com\",   \"isAdmin\": false,   \"address\": \"Manchester\",   \"cityID\": {       \"id\": 103,       \"name\": \"city1\",       \"country\": \"country1\",       \"population\": \"200000\",       \"timezone\": \"GMT+5:30\",       \"longitude\": 23.66,       \"latitude\": 454.454   },   \"username\": \"test1\" },\"securityQuestion1\": \"What is mother maiden name?\",\"securityQuestion2\": \"What is your favourite movie?\",\"securityQuestion3\":\"Whats is your favourite sport?\",\"securityAnswer1\":\"M1\",\"securityAnswer2\":\"V1\",\"securityAnswer3\":\"S1\"}";
        User user = new User();
        user.setId(104);
        when(authUserDetailService.signup(any(SignupRequest.class)))
                .thenReturn(user);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).content(signupRequest)
                .contentType("application/json").
                accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        User response = mapFromJson(mvcResult.getResponse().getContentAsString(), User.class);
        assertEquals(200, status);
        assertEquals(104, (int)response.getId());
    }

}
