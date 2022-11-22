package com.bptn.weatherapp.response;

import java.util.ArrayList;

public class WeatherApiResponse {
	
	   private CityResponse city;
	   private String cod;
	   private Double message;
	   private Double cnt;
	   private ArrayList<ListResponse> list = new ArrayList<>();
	   
	   
	public CityResponse getCity() {
		return city;
	}
	public void setCity(CityResponse city) {
		this.city = city;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Double getMessage() {
		return message;
	}
	public void setMessage(Double message) {
		this.message = message;
	}
	public Double getCnt() {
		return cnt;
	}
	public void setCnt(Double cnt) {
		this.cnt = cnt;
	}
	public ArrayList<ListResponse> getList() {
		return list;
	}
	public void setList(ArrayList<ListResponse> list) {
		this.list = list;
	}
	   
	   
}
