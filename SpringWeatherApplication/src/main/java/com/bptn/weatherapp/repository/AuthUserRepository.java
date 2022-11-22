package com.bptn.weatherapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bptn.weatherapp.models.AuthUserDetail;
import com.bptn.weatherapp.models.User;

public interface AuthUserRepository extends JpaRepository<AuthUserDetail, Integer> {
	
	   AuthUserDetail findAuthUserDetailByUserIDAndUserPassword(User userId, String userPassword);

}
