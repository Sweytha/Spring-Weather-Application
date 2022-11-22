package com.bptn.weatherapp.repository;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bptn.weatherapp.AbstractTest;
import com.bptn.weatherapp.models.User;

public class UserRepositoryTest extends AbstractTest{
	
	@MockBean
	private UserRepository userRepository;
	
	private User user;
	
	private String username = "JJ100";
    private int userId = 100;
    
    @Override
    @Before
    public void setUp() {
        super.setUp();
        user = new User();
        user.setUsername(username);
        user.setId(userId);
    }

    @Test
    public void testFindUserByUsername(){
        when(userRepository.findUserByUsername(username)).thenReturn(user);
        User result = userRepository.findUserByUsername(username);
        assertEquals(username, result.getUsername());
        assertEquals(userId, (int)result.getId());
    }

    @Test
    public void testFindUserById(){
        when(userRepository.findUserById(userId)).thenReturn(user);
        User result = userRepository.findUserById(userId);
        assertEquals(username, result.getUsername());
        assertEquals(userId, (int)result.getId());
    }

}
