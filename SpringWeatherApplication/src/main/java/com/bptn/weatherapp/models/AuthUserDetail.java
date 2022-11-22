package com.bptn.weatherapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"AuthUserDetail\"")
public class AuthUserDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    
    @Column(name = "\"userPassword\"")
    private String userPassword;

    
    @Column(name = "\"securityQuestion1\"")
    private String securityQuestion1;

    
    @Column(name = "\"securityQuestion2\"")
    private String securityQuestion2;

    
    @Column(name = "\"securityQuestion3\"")
    private String securityQuestion3;

    
    @Column(name = "\"securityAnswer1\"")
    private String securityAnswer1;

    
    @Column(name = "\"securityAnswer2\"")
    private String securityAnswer2;

    
    @Column(name = "\"securityAnswer3\"")
    private String securityAnswer3;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "\"userID\"", nullable = false)
    private User userID;

    
	public AuthUserDetail() {
		super();
	}

	public AuthUserDetail(Integer id, String username, String userPassword, String securityQuestion1,
			String securityQuestion2, String securityQuestion3, String securityAnswer1, String securityAnswer2,
			String securityAnswer3, User userID) {
		super();
		this.id = id;
		this.username = username;
		this.userPassword = userPassword;
		this.securityQuestion1 = securityQuestion1;
		this.securityQuestion2 = securityQuestion2;
		this.securityQuestion3 = securityQuestion3;
		this.securityAnswer1 = securityAnswer1;
		this.securityAnswer2 = securityAnswer2;
		this.securityAnswer3 = securityAnswer3;
		this.userID = userID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSecurityQuestion1() {
		return securityQuestion1;
	}

	public void setSecurityQuestion1(String securityQuestion1) {
		this.securityQuestion1 = securityQuestion1;
	}

	public String getSecurityQuestion2() {
		return securityQuestion2;
	}

	public void setSecurityQuestion2(String securityQuestion2) {
		this.securityQuestion2 = securityQuestion2;
	}

	public String getSecurityQuestion3() {
		return securityQuestion3;
	}

	public void setSecurityQuestion3(String securityQuestion3) {
		this.securityQuestion3 = securityQuestion3;
	}

	public String getSecurityAnswer1() {
		return securityAnswer1;
	}

	public void setSecurityAnswer1(String securityAnswer1) {
		this.securityAnswer1 = securityAnswer1;
	}

	public String getSecurityAnswer2() {
		return securityAnswer2;
	}

	public void setSecurityAnswer2(String securityAnswer2) {
		this.securityAnswer2 = securityAnswer2;
	}

	public String getSecurityAnswer3() {
		return securityAnswer3;
	}

	public void setSecurityAnswer3(String securityAnswer3) {
		this.securityAnswer3 = securityAnswer3;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}
    
    

}
