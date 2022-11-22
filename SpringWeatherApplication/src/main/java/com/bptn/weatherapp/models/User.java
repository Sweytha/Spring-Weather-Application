package com.bptn.weatherapp.models;

import java.time.Instant;

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
@Table(name = "\"User\"")
public class User {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	  private Integer id;

	    @Column(name = "\"firstName\"")
	    private String firstName;

	    @Column(name = "\"lastName\"")
	    private String lastName;

	    @Column(name = "\"emailID\"")
	    private String emailID;
	   
	    @Column(name = "\"isAdmin\"")
	    private boolean isAdmin;

	    @Column(name = "address")
	    private String address;

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "\"cityID\"", nullable = false)
	    private City cityID;

	    @Column(name = "\"createdOn\"")
	    private Instant createdOn;

	    @Column(name = "username")
	    private String username;

	    @Column(name = "phone")
	    private String phone;
	    
	    

		public User() {
			super();
		}

		public User(Integer id, String firstName, String lastName, String emailID, boolean isAdmin, String address,
				City cityID, Instant createdOn, String username, String phone) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.emailID = emailID;
			this.isAdmin = isAdmin;
			this.address = address;
			this.cityID = cityID;
			this.createdOn = createdOn;
			this.username = username;
			this.phone = phone;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailID() {
			return emailID;
		}

		public void setEmailID(String emailID) {
			this.emailID = emailID;
		}

		public boolean isAdmin() {
			return isAdmin;
		}

		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public City getCityID() {
			return cityID;
		}

		public void setCityID(City cityID) {
			this.cityID = cityID;
		}

		public Instant getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Instant createdOn) {
			this.createdOn = createdOn;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}
	    
	    


}
