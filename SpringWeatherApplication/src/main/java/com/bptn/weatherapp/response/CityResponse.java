package com.bptn.weatherapp.response;

public class CityResponse {

	private int id;
    private String name;
    CoordResponse coord;
    private String country;
    private Double population;
    private Double timezone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CoordResponse getCoord() {
		return coord;
	}
	public void setCoord(CoordResponse coord) {
		this.coord = coord;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Double getPopulation() {
		return population;
	}
	public void setPopulation(Double population) {
		this.population = population;
	}
	public Double getTimezone() {
		return timezone;
	}
	public void setTimezone(Double timezone) {
		this.timezone = timezone;
	}
    
    
}
