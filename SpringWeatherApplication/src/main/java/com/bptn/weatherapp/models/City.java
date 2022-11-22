package com.bptn.weatherapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "\"City\"")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class City {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name = "id", nullable = false)
	  private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "country")
	    private String country;

	    @Column(name = "population")
	    private String population;

	    @Column(name = "timezone")
	    private String timezone;

	    @Column(name = "longitude")
	    private Double longitude;

	    @Column(name = "latitude")
	    private Double latitude;
	    
	    

		public City() {
			super();
		}

		public City(Integer id, String name, String country, String population, String timezone, Double longitude,
				Double latitude) {
			super();
			this.id = id;
			this.name = name;
			this.country = country;
			this.population = population;
			this.timezone = timezone;
			this.longitude = longitude;
			this.latitude = latitude;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPopulation() {
			return population;
		}

		public void setPopulation(String population) {
			this.population = population;
		}

		public String getTimezone() {
			return timezone;
		}

		public void setTimezone(String timezone) {
			this.timezone = timezone;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		@Override
		public String toString() {
			return "City [id=" + id + ", name=" + name + ", country=" + country + ", population=" + population
					+ ", timezone=" + timezone + ", longitude=" + longitude + ", latitude=" + latitude + "]";
		}
	
	    

}
